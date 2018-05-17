package fr.pinon.checkers;

import fr.pinon.checkers.controler.CheckersGameControler;
import fr.pinon.checkers.model.CheckersGameModel;
import fr.pinon.checkers.model.Coord;
import fr.pinon.checkers.model.PieceGUI;
import fr.pinon.checkers.vue.CheckersGameGUI;
import fr.pinon.checkers.vue.CheckersGameGUIData;

import javax.swing.*;
import java.awt.*;

public class CheckersGamePOOMVCLauncher {

    public static void main(String[] args) {

        CheckersGameModel checkersGameModel = new CheckersGameModel(newBlackCoords(), newWhiteCoords(), 10, PieceGUI.PieceColor.BLANC);
        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(Color.BLUE, Color.LIGHT_GRAY, Color.BLACK, Color.WHITE, 10);
        CheckersGameControler checkersGameControler = new CheckersGameControler(checkersGameGUIData, checkersGameModel);

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
                new Coord(1, 6),
        };
    }

    private static Coord[] newWhiteCoords() {
        return new Coord[]{
                new Coord(0, 7),
                new Coord(2, 7),
                new Coord(4, 7),
                new Coord(6, 7),
                new Coord(8, 7),
                new Coord(1, 8),
                new Coord(3, 8),
                new Coord(5, 8),
                new Coord(7, 8),
                new Coord(9, 8),
                new Coord(0, 9),
                new Coord(2, 9),
                new Coord(4, 9),
                new Coord(6, 9),
                new Coord(8, 9),
        };
    }
}
