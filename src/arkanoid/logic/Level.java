package arkanoid.logic;

import arkanoid.dataaccess.ArkanoidFactory;
import arkanoid.logic.sprites.*;

import java.util.*;

/**
 * Created by Jasper on 21/12/2014.
 */
public class Level extends Observable {
    private int levelNumber;
    private List<Block> blocks;
    private Paddle player1;
    private List<Ball> balls;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private Timer timer;
    private boolean paused;

    public Level(int levelNumber, ArkanoidFactory arkanoidFactory)
    {
        setLevelNumber(levelNumber);
        blocks = arkanoidFactory.createBlocksOfLevel(levelNumber);
        player1 = new Paddle(WIDTH / 2, HEIGHT - 10, 70, 10, 10);
        Ball ball = new Ball(120, 120, 10, 5, 5);
        balls = new ArrayList<Ball>();
        balls.add(ball);
    }

    public void start()
    {
        paused = false;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                player1.move();
                balls.get(0).move();
                stateChanged();
            }
        }, 0, 17);
    }

    public void pause()
    {
        paused = true;
        timer.cancel();
    }

    private void setLevelNumber(int levelNumber)
    {
        if (levelNumber < 0)
            throw new IllegalArgumentException();
        this.levelNumber = levelNumber;
    }

    public Iterator<Sprite> createSpriteIterator() {
        List<Sprite> sprites = new ArrayList<Sprite>();
        sprites.addAll(blocks);
        sprites.add(player1());
        sprites.addAll(balls);
        return sprites.iterator();
    }

    public Iterator<Block> createBlockIterator()
    {
        return blocks.iterator();
    }

    public Iterator<Ball> createBallIterator()
    {
        return balls.iterator();
    }

    public int levelNumber()
    {
        return levelNumber;
    }

    public Paddle player1() {
        return player1;
    }

    private void stateChanged()
    {
        setChanged();
        notifyObservers();
    }

    public boolean isPaused() {
        return paused;
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }
}
