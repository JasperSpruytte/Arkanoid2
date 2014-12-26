package arkanoid.logic.collision;

import arkanoid.logic.sprites.Sprite;

/**
 * Created by Jasper on 26/12/2014.
 */
public class Collision {
    private Sprite sprite1;
    private Sprite sprite2;

    public Collision(Sprite sprite1, Sprite sprite2)
    {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
    }

    public Sprite sprite1()
    {
        return sprite1;
    }

    public Sprite sprite2()
    {
        return sprite2;
    }
}
