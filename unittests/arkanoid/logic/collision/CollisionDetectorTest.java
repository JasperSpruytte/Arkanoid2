package arkanoid.logic.collision;

import arkanoid.logic.Level;
import static org.junit.Assert.*;

import arkanoid.logic.TestArkanoidFactory;
import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Block;
import arkanoid.logic.sprites.Paddle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 26/12/2014.
 */
public class CollisionDetectorTest {

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

        TestArkanoidFactory testArkanoidFactory = new TestArkanoidFactory();
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(block);
        testArkanoidFactory.setBlocksOfLevel(0, blocks);
        Level level = new Level(0, testArkanoidFactory);
        level.addBall(ball);
        CollisionDetector collisionDetector = new CollisionDetector(level);

        List<Collision> collisions = collisionDetector.detectCollisions();

        assertTrue(collisions.size() >= 1);
    }

    @Test
    public void detectCollisions_detectsCollisionBetweenBallAndPaddle()
    {
        Level level = new Level(0, new TestArkanoidFactory());
        Paddle paddle = level.player1();
        int ballDiameter = 5;
        int ballX = paddle.x();
        int ballY = paddle.y() - ballDiameter + 1;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 1, 1);
        level.addBall(ball);
        CollisionDetector collisionDetector = new CollisionDetector(level);

        List<Collision> collisions = collisionDetector.detectCollisions();

        assertTrue(collisions.size() >= 1);
    }
}
