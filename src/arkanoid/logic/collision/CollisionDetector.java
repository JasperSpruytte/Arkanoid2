package arkanoid.logic.collision;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.Ball;
import arkanoid.logic.sprites.Block;
import arkanoid.logic.sprites.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jasper on 26/12/2014.
 */
public class CollisionDetector {
    Level level;

    public CollisionDetector(Level level) {
        this.level = level;
    }

    public List<Collision> detectCollisions() {
        List<Collision> collisions = new ArrayList<Collision>();

        for (Iterator<Ball> balls = level.createBallIterator(); balls.hasNext();)
        {
            Ball ball = balls.next();
            checkSpriteCollision(ball, level.player1(), collisions);

            for (Iterator<Block> blocks = level.createBlockIterator(); blocks.hasNext();)
            {
                Block block = blocks.next();
                checkSpriteCollision(ball, block, collisions);
            }
        }
        
        return collisions;
    }

    private void checkSpriteCollision(Sprite sprite1, Sprite sprite2, List<Collision> collisions)
    {
        Rectangle sprite1Rectangle = new Rectangle(sprite1.width(), sprite1.height());
        Rectangle sprite2Rectangle = new Rectangle(sprite2.width(), sprite2.height());

        if (sprite1Rectangle.intersects(sprite2Rectangle))
        {
            collisions.add(new Collision(sprite1, sprite2));
        }
    }
}
