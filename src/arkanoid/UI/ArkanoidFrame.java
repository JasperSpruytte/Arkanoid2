package arkanoid.UI;

import javax.swing.*;

/**
 * Created by Jasper on 21/12/2014.
 */
public class ArkanoidFrame extends JFrame {

    public ArkanoidFrame()
    {
        setTitle("Arkanoid");
        setResizable(false);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LevelPanel());
        pack();
        setVisible(true);
    }

}
