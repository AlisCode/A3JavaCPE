package fr.pinon.checkers.vue;

import fr.pinon.checkers.controler.CaseClickable;
import fr.pinon.checkers.controler.CheckersGameControler;
import fr.pinon.checkers.controler.PieceClickable;
import fr.pinon.checkers.model.PieceGUI;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.IntStream;

public class CheckersGameGUIBoard extends JPanel implements PropertyChangeListener {

    /**
     * Le contrôleur du jeu
     */
    private CheckersGameControler checkersGameControler;

    /**
     * La taille du plateau
     */
    private int size;

    /**
     * La pièce selectionnée
     */
    private JPanel selectedPieceGUI;

    /**
     * Constructeur de la classe CheckersGameGUIBoard
     *
     * @param controler Le controler du jeu
     */
    public CheckersGameGUIBoard(CheckersGameControler controler) {
        this.checkersGameControler = controler;
        this.size = checkersGameControler.getSize();
        this.selectedPieceGUI = null;

        this.checkersGameControler.addPropertyChangeListener(this);
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
        CaseClickable case_listener = new CaseClickable(this.checkersGameControler);

        IntStream xStream = IntStream.range(0, this.size);
        xStream.forEach(x -> {
            IntStream yStream = IntStream.range(0, this.size);
            yStream.forEach(y -> {
                JPanel case_to_add = new SquareGUI((x + y) % 2 == 1 ? this.checkersGameControler.getColorBlackSquare() : this.checkersGameControler.getColorWhiteSquare());
                case_to_add.addMouseListener(case_listener);
                this.add(case_to_add);
                this.checkersGameControler.addCoord(case_to_add, y, x);
            });
        });


    }

    /**
     * Place les pions sur le plateau
     */
    private void placePions() {
        PieceClickable piece_listener = new PieceClickable(this.checkersGameControler);

        for (int joueur = 0; joueur < 2; joueur++) {
            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < 3; y++) {
                    int index_case = (y + (this.size - 3) * joueur) * this.size + x;
                    if ((x + y) % 2 != joueur) {

                        JPanel panel_case = (JPanel) this.getComponent(index_case);

                        JPanel panel_pion;
                        if (joueur == 0) {
                            panel_pion = new PieceGUI(this.checkersGameControler, PieceGUI.PieceColor.NOIR);
                        } else {
                            panel_pion = new PieceGUI(this.checkersGameControler, PieceGUI.PieceColor.BLANC);
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("selectedPieceGUI")) this.selectedPieceGUI = (JPanel) evt.getNewValue();
        if (evt.getPropertyName().equals("movePiece")) this.movePiece((JPanel) evt.getNewValue());
    }
}
