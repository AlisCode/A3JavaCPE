package fr.pinon.checkers;

import javax.swing.*;

public class CheckersGameGUI extends JFrame {

    /**
     * Le plateau de jeu
     */
    private JPanel checkersBoard;

    /**
     * La barre présente en haut de l'application
     */
    private JMenuBar menuBar;

    /**
     * Constructeur pour la classe CheckersGameGUIData
     *
     * @param checkersGameGUIData
     */
    public CheckersGameGUI(CheckersGameGUIData checkersGameGUIData) {
        super();

        this.checkersBoard = new CheckersGameGUIBoard(checkersGameGUIData);
        this.menuBar = new CheckersGameGUIMenu(checkersGameGUIData);
        this.setJMenuBar(menuBar);
        this.setContentPane(checkersBoard);

    }
}
