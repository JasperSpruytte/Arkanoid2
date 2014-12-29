package arkanoid.logic.collision;

import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Paddle;
import arkanoid.logic.sprites.Sprite;

/**
 * Created by Jasper on 26/12/2014.
 */
public class Collision {
    public static final int NONE = -1;
    public static final int TOP = 0;
    public static final int RIGHT = 1;
    public static final int LEFT = 3;
    private Sprite sprite1;
    private Sprite sprite2;
    private int sideTouched;

    public Collision(Sprite sprite1, Sprite sprite2)
    {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        sideTouched = NONE;
    }

    public Collision(Sprite sprite, int sideOfScreenTouched) {
        sprite1 = sprite;
        sprite2 = null;
        sideTouched = sideOfScreenTouched;
    }

    public Sprite sprite1()
    {
        return sprite1;
    }

    public Sprite sprite2()
    {
        return sprite2;
    }

    public int sideTouched() { return sideTouched; }

    @Override
    public String toString()
    {
        if (sprite2 != null)
            return sprite1().getClass().getName() + " " + sprite2.getClass().getName();
        else
            return sprite1().getClass().getName();
    }
}
