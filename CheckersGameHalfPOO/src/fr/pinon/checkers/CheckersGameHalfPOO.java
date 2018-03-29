package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameHalfPOO {

    private JFrame frame;
    private JPanel checkersBoard;
    private Color colorWhite, colorBlack;
    private JPanel selectedPieceGUI;
    private static final int WINDOW_SIZE = 600;
    private static final int SIZE = 10;

    public static void main(String[] args) {
        new CheckersGameHalfPOO();
    }

    public CheckersGameHalfPOO() {

        this.colorBlack = Color.BLUE;
        this.colorWhite = Color.LIGHT_GRAY;

        this.frame = setFrameConfig("Jeu de dames - Half POO");

        this.checkersBoard = setCheckerboard();
        this.frame.add(this.checkersBoard);
        this.frame.setVisible(true);
    }

    private JFrame setFrameConfig(String name) {
        JFrame frame = new JFrame();

        frame.setSize(WINDOW_SIZE, WINDOW_SIZE);
        frame.setTitle(name);

        return frame;
    }

    private JPanel setCheckerboard() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(SIZE, SIZE);
        panel.setLayout(layout);

        createDamier(panel);
        placePions(panel);

        return panel;
    }

    private void createDamier(JPanel panel) {

        CaseClickable case_listener = new CaseClickable();

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                JPanel case_to_add = new JPanel();
                if ((x + y) % 2 == 1) {
                    case_to_add.setBackground(Color.BLACK);
                } else {
                    case_to_add.setBackground(Color.WHITE);
                }
                case_to_add.addMouseListener(case_listener);
                panel.add(case_to_add);
            }
        }
    }

    private void placePions(JPanel panel) {

        PieceClickable piece_listener = new PieceClickable();

        for (int joueur = 0; joueur < 2; joueur++) {
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < 3; y++) {
                    int index_case = (y + (SIZE - 3) * joueur) * SIZE + x;
                    if ((x + y) % 2 != joueur) {

                        JPanel panel_case = (JPanel) panel.getComponent(index_case);

                        JPanel panel_pion = new JPanel();
                        if (joueur == 0) {
                            panel_pion.setBackground(this.colorBlack);
                        } else {
                            panel_pion.setBackground(this.colorWhite);
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
