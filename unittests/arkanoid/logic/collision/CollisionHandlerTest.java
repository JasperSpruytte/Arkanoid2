package arkanoid.logic.collision;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Paddle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 27/12/2014.
 */
public class CollisionHandlerTest {
    private List<Collision> collisions;
    private CollisionHandler collisionHandler;

    @Before
    public void before()
    {
        collisions = new ArrayList<Collision>();
        collisionHandler = new CollisionHandler();
    }

    @Test
    public void handleCollisions_paddleCanNotGoOffLeftSideOfTheScreen()
    {
        int paddleX = -1;
        Paddle paddle = new Paddle(paddleX, 5, 5, 5, 5);
        collisions.add(new Collision(paddle, Collision.LEFT));

        collisionHandler.handleCollisions(collisions);

        assertTrue(paddle.x() >= 0);
    }

    @Test
    public void handleCollisions_paddleCanNotGoOffRightSideOfTheScreen()
    {
        int paddleX = Level.WIDTH + 1;
        Paddle paddle = new Paddle(paddleX, 5, 5, 5, 5);
        collisions.add(new Collision(paddle, Collision.RIGHT));

        collisionHandler.handleCollisions(collisions);

        assertTrue(paddle.x() <= Level.WIDTH);
    }

    @Test
    public void handleCollisions_BallBouncesOffLeftSideOfScreen()
    {
        int ballX = 0;
        int ballHorizontalSpeed = -5;
        Ball ball = new Ball(ballX, 5, 5, ballHorizontalSpeed, 5);
        collisions.add(new Collision(ball, Collision.LEFT));

        collisionHandler.handleCollisions(collisions);

        assertTrue(ball.horizontalSpeed() > 0);
    }

    @Test
    public void handleCollisions_BallBouncesOffRightSideOfScreen()
    {
        int ballDiameter = 5;
        int ballX = Level.WIDTH + ballDiameter;
        int ballHorizontalSpeed = 5;
        Ball ball = new Ball(ballX, 5, ballDiameter, ballHorizontalSpeed, 5);
        collisions.add(new Collision(ball, Collision.RIGHT));

        collisionHandler.handleCollisions(collisions);

        assertTrue(ball.horizontalSpeed() < 0);
    }

    @Test
    public void handleCollisions_BallBouncesOffTopSideOfScreen()
    {
        int ballY = 0;
        int ballVerticalSpeed = -1;
        Ball ball = new Ball(5, ballY, 5, 5, ballVerticalSpeed);
        collisions.add(new Collision(ball, Collision.TOP));

        collisionHandler.handleCollisions(collisions);

        assertTrue(ball.verticalSpeed() > 0);
    }

    @Test
    public void handleCollisions_ballBouncesToTheLeftIfItTouchedTheLeftTopSideOfThePaddle()
    {
        int ballX = 50;
        int ballDiameter = 5;
        int ballHorizontalSpeed = 5;
        int paddleY = 10;
        int ballY = paddleY - ballDiameter;
        int paddleX = ballX;
        int paddleWidth = 50;
        Ball ball = new Ball(ballX, ballY, ballDiameter, 5, 10);
        Paddle paddle = new Paddle(paddleX, paddleY, paddleWidth, 10, 10);
        collisions.add(new Collision(ball, paddle));

        collisionHandler.handleCollisions(collisions);

        assertTrue(ball.horizontalSpeed() < 0);
    }

}
