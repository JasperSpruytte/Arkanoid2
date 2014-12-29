package arkanoid.logic.sprites;

import arkanoid.logic.sprites.drawing.ImageFactory;
import arkanoid.logic.sprites.drawing.MonochromeCircleFactory;

/**
 * Created by Jasper on 22/12/2014.
 */
public class Ball extends Sprite {
    private int horizontalSpeed;
    private int verticalSpeed;
    private final String COLOR = "#000000";
    private ImageFactory imageFactory;

    public Ball(int x, int y, int diameter, int horizontalSpeed, int verticalSpeed) {
        super(x, y, diameter, diameter);
        this.verticalSpeed = verticalSpeed;
        this.horizontalSpeed = horizontalSpeed;
        imageFactory = new MonochromeCircleFactory(width(), COLOR);
    }

    @Override
    protected ImageFactory createImageCreator() {
        return imageFactory;
    }

    public void move() {
        setX(x() + horizontalSpeed);
        setY(y() + verticalSpeed);
    }

    public int horizontalSpeed()
    {
        return horizontalSpeed;
    }

    public void reverseHorizontalDirection()
    {
        horizontalSpeed *= -1;
    }

    public int verticalSpeed() {
        return verticalSpeed;
    }

    public void reverseVerticalDirection() {
        verticalSpeed *= -1;
    }

    public void moveLeft() {
        horizontalSpeed = -5;
    }
}
