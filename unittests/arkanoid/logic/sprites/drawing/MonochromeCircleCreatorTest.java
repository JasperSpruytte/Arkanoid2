package arkanoid.logic.sprites.drawing;

import org.junit.Assert;
import org.junit.Test;

import java.awt.image.BufferedImage;

/**
 * Created by Jasper on 22/12/2014.
 */
public class MonochromeCircleCreatorTest {

    @Test
    public void createImage_correctDiameter()
    {
        int diameter = 10;
        String color = "#ffffff";
        MonochromeCircleFactory circleCreator = new MonochromeCircleFactory(diameter, color);
        BufferedImage image = (BufferedImage)circleCreator.createImage();

        Assert.assertEquals(diameter, image.getWidth());
        Assert.assertEquals(diameter, image.getHeight());
    }
}
