package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameGUIBoard extends JPanel {

    private CheckersGameGUIData checkersGameGUIData;
    private int size;
    private JPanel selectedPieceGUI;

    /**
     * Constructeur de la classe CheckersGameGUIBoard
     *
     * @param checkersGameGUIData Les données utiles au board (couleurs principalement)
     */
    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.size = checkersGameGUIData.getSize();
        this.selectedPieceGUI = null;

        this.setCheckerboard();
    }


    /**
     * Crée la board (damier + pions) sur ce JPanel
     */
    private void setCheckerboard() {
        GridLayout layout = new GridLayout(this.size, this.size);
        this.setLayout(layout);

        this.createDamier();
        this.placePions();
    }

    /**
     * Crée le damier sur ce JPanel
     */
    private void createDamier() {
        CaseClickable case_listener = new CaseClickable();

        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                JPanel case_to_add;
                if ((x + y) % 2 == 1) {
                    case_to_add = new SquareGUI(this.checkersGameGUIData.getColorBlackSquare());
                } else {
                    case_to_add = new SquareGUI(this.checkersGameGUIData.getColorWhiteSquare());
                }
                case_to_add.addMouseListener(case_listener);
                this.add(case_to_add);
            }
        }
    }

    /**
     * Place les pions sur le plateau
     */
    private void placePions() {
        PieceClickable piece_listener = new PieceClickable();

        for (int joueur = 0; joueur < 2; joueur++) {
            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < 3; y++) {
                    int index_case = (y + (this.size - 3) * joueur) * this.size + x;
                    if ((x + y) % 2 != joueur) {

                        JPanel panel_case = (JPanel) this.getComponent(index_case);

                        JPanel panel_pion;
                        if (joueur == 0) {
                            panel_pion = new PieceGUI(this.checkersGameGUIData, PieceGUI.PieceColor.NOIR);
                        } else {
                            panel_pion = new PieceGUI(this.checkersGameGUIData, PieceGUI.PieceColor.BLANC);
                        }

                        panel_pion.addMouseListener(piece_listener);
                        panel_case.add(panel_pion);

                    }
                }
            }
        }
    }

    /**
     * Setter pour la pièce selectionnée
     *
     * @param piece
     */
    private void setSelectedPieceGUI(JPanel piece) {
        this.selectedPieceGUI = piece;
    }

    /**
     * Bouge la piece selectionnée (this.selectedPieceGUI) au JPanel de destination
     *
     * @param dest La destination choisie
     */
    private void movePiece(JPanel dest) {

        // Evite le cas où selectedPieceGUI est vide
        if (this.selectedPieceGUI != null) {
            // Recupère le parent afin de retirer selectedPieceGUI
            JPanel parent = (JPanel) this.selectedPieceGUI.getParent();

            // Retire la pièce et ré-affiche la case
            parent.removeAll();
            parent.repaint();

            // Retire la pièce déjà présente dans la destination (s'il y en a une)
            dest.removeAll();

            // Ajoute la pièce selectionnée dans la case de destination et ré-affiche ladite case
            dest.add(this.selectedPieceGUI);
            dest.repaint();
        }

    }

    /**
     * Un écouteur pour les pièces qui sont clickables
     */
    private class PieceClickable implements MouseListener {

        /**
         * Appelé quand la pièce est clickée
         *
         * @param e L'évènement généré
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel piece = (JPanel) e.getSource();
            setSelectedPieceGUI(piece);
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

    /**
     * Un écouteur pour les cases clickables du damier
     */
    private class CaseClickable implements MouseListener {

        /**
         * Appellé quand la case est clickée
         *
         * @param e L'évènement généré
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel case_click = (JPanel) e.getSource();
            movePiece(case_click);
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

}
