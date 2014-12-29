package arkanoid.logic.collision;

import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Paddle;

import java.util.List;

/**
 * Created by Jasper on 27/12/2014.
 */
public class CollisionHandler {
    public void handleCollisions(List<Collision> collisions) {
        for (Collision collision: collisions)
        {
            if (collision.sprite2() == null)
            {

                if (collision.sprite1() instanceof Paddle)
                {
                    Paddle paddle = (Paddle)collision.sprite1();
                    if (collision.sideTouched() == Collision.LEFT)
                        paddle.goToLeftEdgeOfScreen();
                    if (collision.sideTouched() == Collision.RIGHT)
                        paddle.goToRightSideOfScreen();
                }

                try {
                    handleBallEdgeCollision((Ball) collision.sprite1(), collision.sideTouched());
                }
                catch (Exception e)
                {

                }
            }

            if (collision.sprite1() instanceof Ball && collision.sprite2() instanceof Paddle)
            {
                Ball ball = (Ball)collision.sprite1();
                Paddle paddle = (Paddle)collision.sprite2();
                
                ball.moveLeft();
            }
        }
    }

    private void handleBallEdgeCollision(Ball ball, int sideOfScreenTouched)
    {
        if (sideOfScreenTouched == Collision.LEFT || sideOfScreenTouched == Collision.RIGHT)
            ball.reverseHorizontalDirection();
        else if (sideOfScreenTouched == Collision.TOP) ball.reverseVerticalDirection();
    }
}
