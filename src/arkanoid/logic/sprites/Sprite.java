package arkanoid.logic.sprites;

import arkanoid.logic.sprites.drawing.ImageFactory;

import java.awt.*;

/**
 * Created by Jasper on 21/12/2014.
 */
public abstract class Sprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image spriteImage;

    public Sprite(int x, int y, int width, int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public Image createImage()
    {
        if (spriteImage == null) {
            ImageFactory imageFactory = createImageCreator();
            spriteImage = imageFactory.createImage();
        }
        return spriteImage;
    }

    protected abstract ImageFactory createImageCreator();

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    protected void setX(int x)
    {
        this.x = x;
    }

    protected void setY(int y)
    {
        this.y = y;
    }

    private void setWidth(int width)
    {
        if (width < 1)
            throw new IllegalArgumentException("The width must be at least 1.");
        this.width = width;
    }

    private void setHeight(int height)
    {
        if (height < 1)
            throw new IllegalArgumentException("The height has to be at least 1.");
        this.height = height;
    }

    public int rightX()
    {
        return x + width;
    }
}
