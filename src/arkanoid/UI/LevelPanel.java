package arkanoid.UI;

import arkanoid.dataaccess.ArkanoidFactory;
import arkanoid.dataaccess.MySQLArkanoidFactory;
import arkanoid.logic.Arkanoid;
import arkanoid.logic.Level;
import arkanoid.logic.sprites.Paddle;
import arkanoid.logic.sprites.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jasper on 21/12/2014.
 */
public class LevelPanel extends JPanel implements Observer {
    private Arkanoid game;
    private Level currentLevel;

    public LevelPanel()
    {
        setLayout(new GridBagLayout());
        initialiseGame();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator<Sprite> sprites = game.getCurrentLevel().createSpriteIterator();
        while (sprites.hasNext())
        {
            Sprite sprite = sprites.next();
            g.drawImage(sprite.createImage(), sprite.x(), sprite.y(), this);
        }

    }

    private void initialiseGame()
    {
        ArkanoidFactory arkanoidFactory = new MySQLArkanoidFactory();
        game = new Arkanoid(arkanoidFactory);
        currentLevel = game.getCurrentLevel();
        currentLevel.addObserver(this);
        setKeybindings();
        currentLevel.start();
    }

    private void setKeybindings()
    {
        final Paddle player1 = currentLevel.player1();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed LEFT"), "player1MoveLeft" );
        getActionMap().put("player1MoveLeft", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player1.startMovingLeft();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "player1StopMovingLeft" );
        getActionMap().put("player1StopMovingLeft", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player1.stopMovingLeft();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed RIGHT"), "player1MoveRight" );
        getActionMap().put("player1MoveRight", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player1.startMovingRight();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "player1StopMovingRight" );
        getActionMap().put("player1StopMovingRight", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player1.stopMovingRight();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed P"), "pause" );
        getActionMap().put("pause", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!currentLevel.isPaused())
                    currentLevel.pause();
                else
                    currentLevel.start();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if (currentLevel != game.getCurrentLevel())
            currentLevel = game.getCurrentLevel();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Level.WIDTH, Level.HEIGHT);
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
