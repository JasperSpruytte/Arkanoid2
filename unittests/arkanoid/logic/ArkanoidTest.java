package arkanoid.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jasper on 21/12/2014.
 */
public class ArkanoidTest {

    @Test
    public void arkanoid_constructor_gameStartsWithLevel0()
    {
        Arkanoid game = new Arkanoid(new TestArkanoidFactory());
        int currentLevelNumber = game.getCurrentLevel().levelNumber();
        int expectedLevel = 0;
        Assert.assertEquals(expectedLevel, currentLevelNumber);
    }
}
