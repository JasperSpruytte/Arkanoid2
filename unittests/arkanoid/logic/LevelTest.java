package arkanoid.logic;

import arkanoid.dataaccess.ArkanoidFactory;
import arkanoid.logic.sprites.Block;
import arkanoid.logic.sprites.Sprite;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jasper on 21/12/2014.
 */
public class LevelTest {

    @Test(expected = IllegalArgumentException.class)
    public void level_levelNumber_canNotBeNegative()
    {
        int illegalLevel = -1;
        Level level = new Level(illegalLevel, null);
    }

    @Test
    public void level_createSpriteIterator_containsAllBlocks()
    {
        int levelNumber = 0;
        TestArkanoidFactory testFactory = new TestArkanoidFactory();
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(10, 10, 10, 10, "#111111"));
        blocks.add(new Block(10, 10, 10, 10, "#111111"));
        blocks.add(new Block(10, 10, 10, 10, "#111111"));
        testFactory.setBlocksOfLevel(levelNumber, blocks);
        Level level = new Level(levelNumber, testFactory);

        Iterator<Sprite> sprites = level.createSpriteIterator();
        int numberOfBlocks = 0;
        while (sprites.hasNext())
        {
            Sprite sprite = sprites.next();
            if (sprite instanceof Block)
                numberOfBlocks++;
        }

        Assert.assertEquals(blocks.size(), numberOfBlocks);
    }
}
