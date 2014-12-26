package arkanoid.logic.sprites;

import org.junit.Assert;
import org.junit.Test;

public class PaddleTest {

    @Test(expected = IllegalArgumentException.class)
    public void paddle_constructor_preventNegativeSpeed()
    {
        int illegalSpeed = -1;
        Paddle paddle = new Paddle(1, 1, 1, 1, illegalSpeed);
    }

    @Test
    public void paddle_move_moveRightIfMoveRightIsTue()
    {
        int initialX = 0;
        int speed = 10;
        Paddle paddle = new Paddle(initialX, 1, 1, 1, speed);
        int expectedNewX = initialX + speed;

        paddle.startMovingRight();
        paddle.move();

        Assert.assertEquals(expectedNewX, paddle.x());
    }

    @Test
    public void paddle_move_moveLeftIfMoveLeftIsTrue()
    {
        int initialX = 10;
        int speed = 10;
        Paddle paddle = new Paddle(initialX, 1, 1, 1, speed);
        int expectedNewX = initialX - speed;

        paddle.startMovingLeft();
        paddle.move();

        Assert.assertEquals(expectedNewX, paddle.x());
    }

}