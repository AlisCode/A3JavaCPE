package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;

public class CheckersGamePOOMVCLauncher {

    public static void main(String[] args) {

        CheckersGameGUIModel checkersGameGUIModel = new CheckersGameGUIModel(newBlackCoords(), newWhiteCoords(), 10, PieceGUI.PieceColor.BLANC);
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

    private static Coord[] newBlackCoords() {
        return new Coord[]{
                new Coord(1, 0),
                new Coord(3, 0),
                new Coord(5, 0),
                new Coord(7, 0),
                new Coord(9, 0),
                new Coord(0, 1),
                new Coord(2, 1),
                new Coord(4, 1),
                new Coord(6, 1),
                new Coord(8, 1),
                new Coord(1, 2),
                new Coord(3, 2),
                new Coord(5, 2),
                new Coord(7, 2),
                new Coord(9, 2),
        };
    }

    private static Coord[] newWhiteCoords() {

    }
}
