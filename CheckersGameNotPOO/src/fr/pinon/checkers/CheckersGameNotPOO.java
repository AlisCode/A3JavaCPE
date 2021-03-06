package fr.pinon.checkers;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckersGameNotPOO {

    private static int WINDOW_SIZE = 600;


    public static void main(String[] args) {
        System.out.println("Hello world !");
        CheckersGameNotPOO checkersFrame = new CheckersGameNotPOO();
        checkersFrame.go();
    }

    public void go() {
        System.out.println("Invocation de la fonction go");
        JFrame frame = new JFrame();
        frame.setSize(WINDOW_SIZE, WINDOW_SIZE);
        frame.setVisible(true);
        frame.setTitle("Checkers Not POO");


        JPanel panelCheckersBoard;
        panelCheckersBoard = setCheckerboard(10);
        frame.add(panelCheckersBoard);


    }

    private JPanel setCheckerboard(int size) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(size, size);
        panel.setLayout(layout);

        createDamier(panel, size);
        placePions(panel, size);

        return panel;
    }

    private void createDamier(JPanel panel, int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                JPanel case_to_add = new JPanel();
                if ((x + y) % 2 == 1) {
                    case_to_add.setBackground(Color.BLACK);
                } else {
                    case_to_add.setBackground(Color.WHITE);
                }
                panel.add(case_to_add);
            }
        }
    }

    private void placePions(JPanel panel, int size) {

        for (int joueur = 0; joueur < 2; joueur++) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < 3; y++) {
                    int index_case = (y + (size - 3) * joueur) * size + x;
                    if ((x + y) % 2 != joueur) {
                        JPanel panel_case = (JPanel) panel.getComponent(index_case);
                        JPanel panel_pion = new JPanel();

                        if (joueur == 0) {
                            panel_pion.setBackground(Color.BLUE);
                        } else {
                            panel_pion.setBackground(Color.LIGHT_GRAY);
                        }
                        panel_case.add(panel_pion);
                    }
                }
            }
        }

    }

}
