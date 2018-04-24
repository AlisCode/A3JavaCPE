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
        this.itemPieceBlanche = new JMenuItem("Pièce Blanche");
        this.itemPieceNoire = new JMenuItem("Pièce Noire");

        this.menuChoixCouleurs.add(itemPieceBlanche);
        this.menuChoixCouleurs.add(itemPieceNoire);
        this.add(menuChoixCouleurs);

        this.itemPieceBlanche.addActionListener(checkersGameControler.new ChangeColorPieceListener(PieceGUI.PieceColor.BLANC));
        this.itemPieceNoire.addActionListener(checkersGameControler.new ChangeColorPieceListener(PieceGUI.PieceColor.NOIR));
    }
}
