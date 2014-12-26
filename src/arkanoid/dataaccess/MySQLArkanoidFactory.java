package arkanoid.dataaccess;

import arkanoid.logic.sprites.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasper on 21/12/2014.
 */
public class MySQLArkanoidFactory implements ArkanoidFactory {
    @Override
    public List<Block> createBlocksOfLevel(int levelNumber) {
        List<Block> blocks = new ArrayList<Block>();

        blocks.add(new Block(0, 0, 10, 10, "#ffffff"));
        blocks.add(new Block(50, 0, 10, 10, "#ffffff"));
        blocks.add(new Block(100, 0, 10, 10, "#ffffff"));

        return blocks;
    }
}
