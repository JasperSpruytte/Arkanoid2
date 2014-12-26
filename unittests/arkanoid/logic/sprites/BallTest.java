package arkanoid.logic.sprites;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jasper on 22/12/2014.
 */
public class BallTest {

    @Test
    public void move_movesAccordingToHorizontalAndVerticalSpeed()
    {
        int x = 5;
        int y = 20;
        int horizontalSpeed = 5;
        int verticalSpeed = 10;
        Ball ball = new Ball(x, y, 10, horizontalSpeed, verticalSpeed);

        ball.move();

        int expectedNewX = x + horizontalSpeed;
        int expectedNewY = y + verticalSpeed;
        Assert.assertEquals(expectedNewX, ball.x());
        Assert.assertEquals(expectedNewY, ball.y());
    }
}
