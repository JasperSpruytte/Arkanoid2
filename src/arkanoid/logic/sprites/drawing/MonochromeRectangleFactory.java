package arkanoid.logic.sprites.drawing;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Jasper on 22/12/2014.
 */
public class MonochromeRectangleFactory implements ImageFactory {
    private int width;
    private int height;
    private Color color;


    public MonochromeRectangleFactory(int width, int height, String color)
    {
        this.width = width;
        this.height = height;
        this.color = ColorConverter.convertStringToColor(color);
    }

    @Override
    public Image createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(color);
        graphics2D.fillRect(0, 0, width, height);
        return image;
    }

}
