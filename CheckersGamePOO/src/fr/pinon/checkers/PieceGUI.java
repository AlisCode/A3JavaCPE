package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;

public class PieceGUI extends JPanel {

    /**
     * Enumération représantant la "couleur théorique" d'une pièce (théorique = la couleur du joueur auquel
     * elle appartient)
     */
    public enum PieceColor {
        BLANC,
        NOIR
    }

    private Color color;
    private PieceColor pieceColor;

    /**
     * Constructeur pour la classe PieceGUI
     *
     * @param col La couleur de la pièce
     */
    public PieceGUI(CheckersGameGUIData data, PieceColor pieceColor) {
        super();
        this.pieceColor = pieceColor;
        switch (pieceColor) {
            case BLANC:
                this.color = data.getColorWhitePiece();
                break;
            case NOIR:
                this.color = data.getColorBlackPiece();
                break;
            default:
                break;
        }
        this.setOpaque(false);
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
}
