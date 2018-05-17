package fr.pinon.checkers.vue;

import fr.pinon.checkers.controler.CaseClickable;
import fr.pinon.checkers.controler.CheckersGameControler;
import fr.pinon.checkers.controler.PieceClickable;
import fr.pinon.checkers.model.Coord;
import fr.pinon.checkers.model.PieceGUI;
import fr.pinon.checkers.model.PieceInfo;
import fr.pinon.checkers.model.PieceModel;

import java.util.List;

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
        this.setCheckerboard(controler.getModelInfo());
    }


    /**
     * Crée la board (damier + pions) sur ce JPanel
     */
    private void setCheckerboard(List<PieceInfo> pieceInfoList) {
        GridLayout layout = new GridLayout(this.size, this.size);
        this.setLayout(layout);

        this.createDamier();
        this.placePions(pieceInfoList);
    }

    /**
     * Crée le damier sur ce JPanel
     */
    private void createDamier() {
        CaseClickable case_listener = new CaseClickable(this.checkersGameControler);

        IntStream.range(0, this.size).forEach(x -> {
            IntStream.range(0, this.size).forEach(y -> {
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
    private void placePions(List<PieceInfo> pieceInfoList) {
        PieceClickable piece_listener = new PieceClickable(this.checkersGameControler);

        pieceInfoList
                .stream()
                .forEach(info -> {
                    JPanel panel_pion = new PieceGUI(this.checkersGameControler, info.getColor());
                    panel_pion.addMouseListener(piece_listener);

                    int index_case = info.getCoords().getY() * this.size + info.getCoords().getX();
                    JPanel panel_case = (JPanel) this.getComponent(index_case);
                    panel_case.add(panel_pion);
                });
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
     * Prend (visuellement) la pièce présente dans la case aux coordonnées données
     *
     * @param coords Les coordonnées de la pièce à prendre
     */
    private void takePieceAtCoords(Coord coords) {

        // Récupère la case aux coordonnées données
        int index = coords.getY() * this.size + coords.getX();
        JPanel panel_case = (JPanel) this.getComponent(index);

        // Vide la case
        panel_case.removeAll();

        // Ré-affiche la case
        panel_case.repaint();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("selectedPieceGUI")) this.selectedPieceGUI = (JPanel) evt.getNewValue();
        if (evt.getPropertyName().equals("movePiece")) this.movePiece((JPanel) evt.getNewValue());
        if (evt.getPropertyName().equals("takePiece"))
            this.takePieceAtCoords(((PieceModel) evt.getNewValue()).getCoord());
    }
}
