package arkanoid.logic.sprites;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.drawing.ImageFactory;
import arkanoid.logic.sprites.drawing.MonochromeRectangleFactory;

/**
 * Created by Jasper on 22/12/2014.
 */
public class Paddle extends Sprite {
    private int speed;
    private boolean movingRight;
    private boolean movingLeft;
    private final String COLOR = "#000000";
    private ImageFactory imageFactory;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        setSpeed(speed);
        imageFactory = new MonochromeRectangleFactory(width, height, COLOR);
    }

    private void setSpeed(int speed)
    {
        if (speed < 0)
            throw new IllegalArgumentException("The speed has to be positive.");
        this.speed = speed;
    }

    public void move() {
        if (movingRight)
            setX(x() + speed);
        if (movingLeft)
            setX(x() - speed);
    }

    public void startMovingRight()
    {
        movingRight = true;
    }

    public void stopMovingRight()
    {
        movingRight = false;
    }

    public void startMovingLeft()
    {
        movingLeft = true;
    }

    public void stopMovingLeft()
    {
        movingLeft = false;
    }

    @Override
    protected ImageFactory createImageCreator() {
        return imageFactory;
    }

    public void goToLeftEdgeOfScreen()
    {
        setX(0);
    }

    public void goToRightSideOfScreen()
    {
        setX(Level.WIDTH - width());
    }
}
