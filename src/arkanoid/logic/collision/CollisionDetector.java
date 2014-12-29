package arkanoid.logic.collision;

import arkanoid.logic.Level;
import arkanoid.logic.sprites.*;

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
        checkBallCollisions(collisions);
        checkIfSpriteHitEdge(level.player1(), collisions);
        return collisions;
    }

    private void checkBallCollisions(List<Collision> collisions)
    {
        for (Iterator<Ball> balls = level.createBallIterator(); balls.hasNext();)
        {
            Ball ball = balls.next();
            checkSpriteCollision(ball, level.player1(), collisions);
            checkIfBallHitBlocks(ball, collisions);
            checkIfSpriteHitEdge(ball, collisions);
        }
    }

    private void checkIfBallHitBlocks(Ball ball, List<Collision> collisions)
    {
        for (Iterator<Block> blocks = level.createBlockIterator(); blocks.hasNext();)
        {
            Block block = blocks.next();
            checkSpriteCollision(ball, block, collisions);
        }
    }

    private void checkIfSpriteHitEdge(Sprite sprite, List<Collision> collisions)
    {
        if (sprite.x() <= 0)
            collisions.add(new Collision(sprite, Collision.LEFT));
        if (sprite.rightX() >= level.WIDTH)
            collisions.add(new Collision(sprite, Collision.RIGHT));
        if (sprite.y() <= 0)
            collisions.add(new Collision(sprite, Collision.TOP));

    }

    private void checkSpriteCollision(Sprite sprite1, Sprite sprite2, List<Collision> collisions)
    {
        Rectangle sprite1Rectangle = new Rectangle(sprite1.x(), sprite1.y(), sprite1.width(), sprite1.height());
        Rectangle sprite2Rectangle = new Rectangle(sprite2.x(), sprite2.y(), sprite2.width(), sprite2.height());

        if (sprite1Rectangle.intersects(sprite2Rectangle))
        {
            collisions.add(new Collision(sprite1, sprite2));
        }
    }
}
