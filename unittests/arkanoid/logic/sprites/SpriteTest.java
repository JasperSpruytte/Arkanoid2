package arkanoid.logic.sprites;

import arkanoid.logic.sprites.drawing.ImageFactory;
import org.junit.Test;

/**
 * Created by Jasper on 21/12/2014.
 */
public class SpriteTest {

    @Test(expected = IllegalArgumentException.class)
    public void sprite_constructor_preventNegativeX()
    {
        int illegalX = -1;
        Sprite sprite = new SpriteMock(illegalX, 10, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sprite_constructor_preventNegativeY()
    {
        int illegalY = -1;
        Sprite sprite = new SpriteMock(10, illegalY, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sprite_constructor_preventWidthLessThenOne()
    {
        int illegalWidth = 0;
        Sprite sprite = new SpriteMock(10, 10, illegalWidth, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sprite_constructor_preventHeightLessThanOne()
    {
        int illegalHeight = 0;
        Sprite sprite = new SpriteMock(10, 10, 10, illegalHeight);
    }

    private class SpriteMock extends Sprite
    {

        public SpriteMock(int x, int y, int width, int height) {
            super(x, y, width, height);
        }

        @Override
        protected ImageFactory createImageCreator() {
            return null;
        }

    }
}
