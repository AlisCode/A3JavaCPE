package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;

public class CheckersGamePOOHalfMVCLauncher {

    public static void main(String[] args) {

        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(Color.BLUE, Color.LIGHT_GRAY, Color.BLACK, Color.WHITE, 10);
        CheckersGameControler checkersGameControler = new CheckersGameControler(checkersGameGUIData);

        JFrame f = new CheckersGameGUI(checkersGameControler);
        setFrameConfig(f, "Jeu de dames - POO");

        checkersGameGUIData.addPropertyChangeListener(checkersGameControler);

        f.setVisible(true);
    }

    private static void setFrameConfig(JFrame f, String name) {
        f.setTitle(name);
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
