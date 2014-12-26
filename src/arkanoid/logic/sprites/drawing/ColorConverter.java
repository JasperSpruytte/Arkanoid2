package arkanoid.logic.sprites.drawing;

import java.awt.*;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Created by Jasper on 22/12/2014.
 */
public final class ColorConverter {

    private ColorConverter() {}

    public static Color convertStringToColor(String color)
    {
        String regex = "^#[0-9a-f]{6}$";
        if (!Pattern.matches(regex, color))
            throw new IllegalArgumentException("The color must be of the format #ffffff.");
        return Color.decode(color);
    }

}
