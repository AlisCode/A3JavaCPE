package fr.pinon.checkers;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Un écouteur pour les cases clickables du damier
 */
public class CaseClickable implements MouseListener {

    private CheckersGameControler checkersGameControler;

    public CaseClickable(CheckersGameControler controler) {
        this.checkersGameControler = controler;
    }

    /**
     * Appellé quand la case est clickée
     *
     * @param e L'évènement généré
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel case_click = (JPanel) e.getSource();
        this.checkersGameControler.movePiece(case_click);
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
