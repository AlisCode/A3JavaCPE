package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckersGameGUIMenu extends JMenuBar {

    private CheckersGameGUIData checkersGameGUIData;

    private JMenu menuChoixCouleurs;
    private JMenuItem itemPieceBlanche;
    private JMenuItem itemPieceNoire;

    public CheckersGameGUIMenu(CheckersGameGUIData checkersGameGUIData) {

        this.checkersGameGUIData = checkersGameGUIData;

        this.menuChoixCouleurs = new JMenu("Choix couleurs");
        this.itemPieceBlanche = new JMenuItem("Piece Blanche");
        this.itemPieceNoire = new JMenuItem("Piece Noire");

        this.menuChoixCouleurs.add(itemPieceBlanche);
        this.menuChoixCouleurs.add(itemPieceNoire);
        this.add(menuChoixCouleurs);

        this.itemPieceBlanche.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Couleur pièce blanche", Color.WHITE);
            checkersGameGUIData.setColorWhitePiece(newColor);
        });

        this.itemPieceNoire.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Couleur pièce noire", Color.BLACK);
            checkersGameGUIData.setColorBlackPiece(newColor);
        });
    }
}
