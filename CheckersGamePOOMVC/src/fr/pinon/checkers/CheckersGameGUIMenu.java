package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class CheckersGameGUIMenu extends JMenuBar {

    private CheckersGameControler checkersGameControler;

    private JMenu menuChoixCouleurs;
    private JMenuItem itemPieceBlanche;
    private JMenuItem itemPieceNoire;

    public CheckersGameGUIMenu(CheckersGameControler checkersGameControler) {

        this.checkersGameControler = checkersGameControler;

        this.menuChoixCouleurs = new JMenu("Choix couleurs");
        this.itemPieceBlanche = new JMenuItem("Piece Blanche");
        this.itemPieceNoire = new JMenuItem("Piece Noire");

        this.menuChoixCouleurs.add(itemPieceBlanche);
        this.menuChoixCouleurs.add(itemPieceNoire);
        this.add(menuChoixCouleurs);

        this.itemPieceBlanche.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Couleur pièce blanche", this.checkersGameControler.getColorWhitePiece());
            if (newColor != null) {
                this.checkersGameControler.setColorWhitePiece(newColor);
            }
        });

        this.itemPieceNoire.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Couleur pièce noire", this.checkersGameControler.getColorBlackPiece());
            if (newColor != null) {
                this.checkersGameControler.setColorBlackPiece(newColor);
            }
        });
    }
}
