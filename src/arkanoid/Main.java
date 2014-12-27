package arkanoid;

import arkanoid.UI.ArkanoidFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try
                {
                    new ArkanoidFrame();
                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                }
            }
        });

    }
}
