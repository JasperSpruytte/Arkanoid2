package arkanoid.logic.sprites;

import arkanoid.logic.sprites.drawing.ImageFactory;
import arkanoid.logic.sprites.drawing.MonochromeRectangleFactory;

/**
 * Created by Jasper on 21/12/2014.
 */
public class Block extends Sprite {
    private ImageFactory imageFactory;

    public Block(int x, int y, int width, int height, String color)
    {
        super(x, y, width, height);
        imageFactory = new MonochromeRectangleFactory(width, height, color);
    }

    @Override
    protected ImageFactory createImageCreator() {
        return imageFactory;
    }
}
