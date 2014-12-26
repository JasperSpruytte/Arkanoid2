package arkanoid.logic.sprites.drawing;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorConverterTest {

    @Test(expected = IllegalArgumentException.class)
    public void convertStringToColor_throwsErrorIfStringNotHexCode()
    {
        String notAColor = "color";
        MonochromeRectangleFactory monochromeRectangleCreator = new MonochromeRectangleFactory(10, 10, notAColor);
    }

}