package arkanoid.logic.collision;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.Paddle;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 27/12/2014.
 */
public class CollisionHandlerTest {

    @Test
    public void handleCollisions_paddleCanNotGoOffLeftSideOfTheScreen()
    {
        List<Collision> collisions = new ArrayList<Collision>();
        int paddleX = -1;
        Paddle paddle = new Paddle(paddleX, 5, 5, 5, 5);
        collisions.add(new Collision(paddle));
        CollisionHandler collisionHandler = new CollisionHandler();

        collisionHandler.handleCollisions(collisions);

        assertTrue(paddle.x() >= 0);
    }

    @Test
    public void handleCollisions_paddleCanNotGoOffRightSideOfTheScreen()
    {
        List<Collision> collisions = new ArrayList<Collision>();
        int paddleX = Level.WIDTH + 1;
        Paddle paddle = new Paddle(paddleX, 5, 5, 5, 5);
        collisions.add(new Collision(paddle));
        CollisionHandler collisionHandler = new CollisionHandler();

        collisionHandler.handleCollisions(collisions);

        assertTrue(paddle.x() <= Level.WIDTH);
    }
}
