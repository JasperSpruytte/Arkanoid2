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
    private Ball ball;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private Timer timer;
    private boolean paused;

    public Level(int levelNumber, ArkanoidFactory arkanoidFactory)
    {
        setLevelNumber(levelNumber);
        blocks = arkanoidFactory.createBlocksOfLevel(levelNumber);
        player1 = new Paddle(WIDTH / 2, HEIGHT - 10, 70, 10, 10);
        ball = new Ball(120, 120, 10, 5, 5);
    }

    public void start()
    {
        paused = false;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                player1.move();
                ball.move();
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
        sprites.add(getPlayer1());
        sprites.add(ball);
        return sprites.iterator();
    }

    public int getLevelNumber()
    {
        return levelNumber;
    }

    public Paddle getPlayer1() {
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
}
