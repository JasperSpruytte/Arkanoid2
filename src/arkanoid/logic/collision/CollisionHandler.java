package arkanoid.logic.collision;

import arkanoid.logic.sprites.Paddle;

import java.util.List;

/**
 * Created by Jasper on 27/12/2014.
 */
public class CollisionHandler {
    public void handleCollisions(List<Collision> collisions) {
        for (Collision collision: collisions)
        {
            if (collision.sprite1() instanceof Paddle && collision.sprite2() == null)
            {
                Paddle paddle = (Paddle)collision.sprite1();
                if (paddle.x() <= 0)
                    paddle.goToLeftEdgeOfScreen();
                else
                    paddle.goToRightSideOfScreen();
            }
        }
    }
}
