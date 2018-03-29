package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameGUIBoard extends JPanel {

    CheckersGameGUIData checkersGameGUIData;
    private int size;
    private JPanel selectedPieceGUI;

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.size = checkersGameGUIData.getSize();
        this.selectedPieceGUI = null;

        this.setCheckerboard();
    }


    private void setCheckerboard() {
        GridLayout layout = new GridLayout(this.size, this.size);
        this.setLayout(layout);

        this.createDamier();
        this.placePions();
    }

    private void createDamier() {
        CaseClickable case_listener = new CaseClickable();

        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                JPanel case_to_add = new JPanel();
                if ((x + y) % 2 == 1) {
                    case_to_add.setBackground(this.checkersGameGUIData.getColorBlackSquare());
                } else {
                    case_to_add.setBackground(this.checkersGameGUIData.getColorWhiteSquare());
                }
                case_to_add.addMouseListener(case_listener);
                this.add(case_to_add);
            }
        }
    }

    private void placePions() {
        PieceClickable piece_listener = new PieceClickable();

        for (int joueur = 0; joueur < 2; joueur++) {
            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < 3; y++) {
                    int index_case = (y + (this.size - 3) * joueur) * this.size + x;
                    if ((x + y) % 2 != joueur) {

                        JPanel panel_case = (JPanel) this.getComponent(index_case);

                        JPanel panel_pion = new JPanel();
                        if (joueur == 0) {
                            panel_pion.setBackground(this.checkersGameGUIData.getColorBlackPiece());
                        } else {
                            panel_pion.setBackground(this.checkersGameGUIData.getColorWhitePiece());
                        }

                        panel_pion.addMouseListener(piece_listener);
                        panel_case.add(panel_pion);

                    }
                }
            }
        }
    }

    private void setSelectedPieceGUI(JPanel piece) {
        this.selectedPieceGUI = piece;
    }

    private void movePiece(JPanel dest) {
        JPanel parent = (JPanel) this.selectedPieceGUI.getParent();
        parent.removeAll();
        parent.repaint();

        dest.removeAll();
        dest.add(this.selectedPieceGUI);
        dest.repaint();
    }


    private class PieceClickable implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel piece = (JPanel) e.getSource();
            setSelectedPieceGUI(piece);
        }

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

    private class CaseClickable implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel case_click = (JPanel) e.getSource();
            movePiece(case_click);
        }

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
