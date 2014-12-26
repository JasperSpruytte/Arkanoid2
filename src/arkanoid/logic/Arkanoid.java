package arkanoid.logic;

import arkanoid.dataaccess.ArkanoidFactory;
import arkanoid.dataaccess.MySQLArkanoidFactory;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jasper on 21/12/2014.
 */
public class Arkanoid {
    private Level currentLevel;

    public Arkanoid(ArkanoidFactory arkanoidFactory)
    {
        currentLevel = new Level(0, arkanoidFactory);
    }

    public Level getCurrentLevel()
    {
        return currentLevel;
    }




}
