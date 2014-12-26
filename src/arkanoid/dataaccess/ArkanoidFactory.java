package arkanoid.dataaccess;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.Block;

import java.util.List;

/**
 * Created by Jasper on 21/12/2014.
 */
public interface ArkanoidFactory {
    public List<Block> createBlocksOfLevel(int levelNumber);
}
