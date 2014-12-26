package arkanoid.logic.sprites.drawing;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MonochromeRectangleCreatorTest {

    @Test
    public void createImage_correctWidthAndHeight()
    {
        int width = 10;
        int height = 10;
        MonochromeRectangleFactory m = new MonochromeRectangleFactory(width, height, "#ffffff");

        BufferedImage blockImage = (BufferedImage)m.createImage();

        Assert.assertEquals(width, blockImage.getWidth());
        Assert.assertEquals(height, blockImage.getHeight());
    }

    @Test
    public void createImage_hasCorrectColor()
    {
        String colorString = "#111111";
        MonochromeRectangleFactory m = new MonochromeRectangleFactory(10, 10, colorString);

        BufferedImage blockImage = (BufferedImage)m.createImage();

        int expectedColorRGB = Color.decode(colorString).getRGB();
        boolean imageHasCorrectColor = true;
        for (int i = 0; i < blockImage.getWidth(); i++) {
            for (int j = 0; j < blockImage.getHeight(); j++) {
                int pixelColorRGB = blockImage.getRGB(i, j);
                if (expectedColorRGB != pixelColorRGB)
                {
                    imageHasCorrectColor = false;
                    break;
                }
            }
        }
        Assert.assertTrue(imageHasCorrectColor);
    }
}