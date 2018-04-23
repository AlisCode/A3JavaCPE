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
     * @param controler Le contrôleur du jeu
     */
    public CheckersGameGUI(CheckersGameControler controler) {
        super();

        this.checkersBoard = new CheckersGameGUIBoard(controler);
        this.menuBar = new CheckersGameGUIMenu(controler);
        this.setJMenuBar(menuBar);
        this.setContentPane(checkersBoard);

    }
}
