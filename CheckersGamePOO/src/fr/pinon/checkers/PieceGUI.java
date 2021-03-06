package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PieceGUI extends JPanel implements PropertyChangeListener {

    /**
     * Enumération représantant la "couleur théorique" d'une pièce (théorique = la couleur du joueur auquel
     * elle appartient)
     */
    public enum PieceColor {
        BLANC,
        NOIR
    }

    /**
     * La couleur (Javax.Swing) de cette pièce
     */
    private Color color;

    /**
     * La couleur "logique" de la piece (notre énumération)
     */
    private PieceColor pieceColor;

    /**
     * Les données de GUI du jeu
     */
    private CheckersGameGUIData checkersGameGUIData;

    /**
     * Constructeur pour la classe PieceGUI
     *
     * @param data       Les données de GUI concernant le jeu
     * @param pieceColor La couleur de la pièce (enum PieceColor)
     */
    public PieceGUI(CheckersGameGUIData data, PieceColor pieceColor) {
        super();
        this.checkersGameGUIData = data;
        this.pieceColor = pieceColor;
        this.assignColor();
        this.setOpaque(false);
        data.addPropertyChangeListener(this);
    }

    /**
     * Affiche la pièce dans le composant JPanel (dégradé de la couleur de la pièce vers le blanc)
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, this.color, this.getWidth(), this.getHeight(), Color.WHITE);
        g2d.setPaint(gp);
        g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * Implémente le pattern Observer
     *
     * @param evt L'évènement correspondant à un changement de propriété
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.assignColor();
        this.repaint();
    }


    /**
     * Assigne la bonne couleur provenant des données à la pièce en fonction de sa couleur "logique" (notre énumération)
     */
    public void assignColor() {
        switch (this.pieceColor) {
            case BLANC:
                this.color = this.checkersGameGUIData.getColorWhitePiece();
                break;
            case NOIR:
                this.color = this.checkersGameGUIData.getColorBlackPiece();
                break;
            default:
                break;
        }
    }
}
