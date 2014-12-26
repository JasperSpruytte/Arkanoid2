package arkanoid.logic.sprites.drawing;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

/**
 * Created by Jasper on 22/12/2014.
 */
public class MonochromeCircleFactory implements ImageFactory {
    private int diameter;
    private Color color;

    public MonochromeCircleFactory(int diameter, String color) {
        this.diameter = diameter;
        this.color = ColorConverter.convertStringToColor(color);
    }

    @Override
    public Image createImage() {
        //ARGB zodat afbeelding transparente achtergrond heeft
        BufferedImage image = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(color);
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
        graphics2D.fill(circle);
        return image;
    }
}
