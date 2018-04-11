package fr.pinon.checkers;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Un écouteur pour les pièces qui sont clickables
 */
public class PieceClickable implements MouseListener {

    /**
     * Le contrôleur du jeu
     */
    private CheckersGameControler controler;

    /**
     * Constructeur de l'écouteur PieceClickable
     *
     * @param checkersGameControler Le contrôleur du jeu
     */
    public PieceClickable(CheckersGameControler checkersGameControler) {
        this.controler = checkersGameControler;
    }


    /**
     * Appelé quand la pièce est clickée
     *
     * @param e L'évènement généré
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel piece = (JPanel) e.getSource();
        this.controler.clickedPiece(piece);
    }

    // Les autres méthodes ne sont pas à implémenter

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
