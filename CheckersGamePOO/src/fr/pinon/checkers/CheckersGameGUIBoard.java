package fr.pinon.checkers;

import javax.swing.*;

public class CheckersGameGUIBoard extends JPanel {

    CheckersGameGUIData checkersGameGUIData;
    private int size;
    private JPanel selectedPieceGUI;

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.size = checkersGameGUIData.getSize();
        this.selectedPieceGUI = null;
    }
}
