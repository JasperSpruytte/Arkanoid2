package arkanoid.logic.collision;

import arkanoid.logic.Level;
import static org.junit.Assert.*;

import arkanoid.logic.TestArkanoidFactory;
import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Block;
import arkanoid.logic.sprites.Paddle;
import arkanoid.logic.sprites.Sprite;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 26/12/2014.
 */
public class CollisionDetectorTest {
    private TestArkanoidFactory testArkanoidFactory;
    private Level level;
    private CollisionDetector collisionDetector;

    @Before
    public void before()
    {
        testArkanoidFactory = new TestArkanoidFactory();
        level = new Level(0, testArkanoidFactory);
        collisionDetector = new CollisionDetector(level);
    }

    @Test
    public void detectCollisions_detectsCollisionBetweenBallAndBlock()
    {
        int ballX = 0;
        int ballY = 0;
        int ballDiameter = 5;
        int blockX = ballX + ballDiameter - 1;
        int blockY = ballY;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 1, 1);
        Block block = new Block(blockX, blockY, 5, 5, "#ffffff");
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(block);
        testArkanoidFactory.setBlocksOfLevel(0, blocks);
        level.addBall(ball);

        List<Collision> collisions = collisionDetector.detectCollisions();

        assertTrue(collisions.size() >= 1);
    }

    @Test
    public void detectCollisions_detectsCollisionBetweenBallAndPaddle()
    {
        Paddle paddle = level.player1();
        int ballDiameter = 5;
        int ballX = paddle.x();
        int ballY = paddle.y() - ballDiameter + 1;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 1, 1);
        level.addBall(ball);

        List<Collision> collisions = collisionDetector.detectCollisions();

        assertTrue(collisions.size() >= 1);
    }

    @Test
    public void detectCollisions_detectsCollisionBetweenBallAndEdge()
    {
        int ballDiameter = 5;
        int ballX = 0;
        int ballY = 0;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 1, 1);
        level.addBall(ball);

        List<Collision> collisions = collisionDetector.detectCollisions();

        boolean detectedCollisionBetweenBallAndEdge = false;
        for (Collision collision: collisions)
        {
            if (collision.sprite1() instanceof Ball && collision.sprite2() == null)
            {
                detectedCollisionBetweenBallAndEdge = true;
                break;
            }
        }

        assertTrue(detectedCollisionBetweenBallAndEdge);
    }

    @Test
    public void detectCollisions_detectsCollisionBetweenPaddleAndEdge()
    {
        Paddle paddle = level.player1();
        paddle.startMovingLeft();
        while (paddle.x() > 0)
        {
            paddle.move();
        }

        List<Collision> collisions = collisionDetector.detectCollisions();

        boolean detectedCollisionBetweenPaddleAndEdge = false;
        for (Collision collision: collisions)
        {
            if (collision.sprite1() instanceof Paddle && collision.sprite2() == null)
            {
                detectedCollisionBetweenPaddleAndEdge = true;
                break;
            }
        }

        assertTrue(detectedCollisionBetweenPaddleAndEdge);
    }

    @Test
    public void detectCollisions_doNotDetectCollisionsThatAreNotCollisions()
    {
        Paddle paddle = level.player1();
        int ballDiameter = 5;
        int ballX = paddle.x() - ballDiameter * 2;
        int ballY = paddle.y() - ballDiameter * 2;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 5, 5);
        level.addBall(ball);

        List<Collision> collisions = collisionDetector.detectCollisions();

        boolean detectedCollisionBetweenBallAndPaddle = false;
        for (Collision collision: collisions)
        {
            Sprite sprite1 = collision.sprite1();
            Sprite sprite2 = collision.sprite2();
            if (sprite1 instanceof Ball && sprite2 instanceof Paddle)
            {
                Ball sprite1Ball = (Ball)sprite1;
                Paddle sprite2Paddle = (Paddle)sprite2;
                if (sprite1Ball == ball && sprite2Paddle == paddle)
                {
                    detectedCollisionBetweenBallAndPaddle = true;
                    break;
                }
            }

        }

        assertFalse(detectedCollisionBetweenBallAndPaddle);
    }

}
