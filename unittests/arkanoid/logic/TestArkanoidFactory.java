package arkanoid.logic;

import arkanoid.dataaccess.ArkanoidFactory;
import arkanoid.logic.sprites.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 21/12/2014.
 */
public class TestArkanoidFactory implements ArkanoidFactory {
    private List<List<Block>> blocksPerLevel;

    public TestArkanoidFactory()
    {
        blocksPerLevel = new ArrayList<List<Block>>();
        for (int i = 0; i < 1; i++)
        {
            blocksPerLevel.add(new ArrayList<Block>());
        }

    }

    @Override
    public List<Block> createBlocksOfLevel(int levelNumber) {
        return blocksPerLevel.get(levelNumber);
    }

    public void setBlocksOfLevel(int levelNumber, List<Block> blocks) {
        blocksPerLevel.set(levelNumber, blocks);
    }
}
