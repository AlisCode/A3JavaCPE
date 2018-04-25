package fr.pinon.checkers.controler;

import fr.pinon.checkers.model.ActionType;
import fr.pinon.checkers.model.CheckersGameModel;
import fr.pinon.checkers.model.Coord;
import fr.pinon.checkers.model.PieceGUI;
import fr.pinon.checkers.vue.CheckersGameGUIData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckersGameControler implements PropertyChangeListener {

    /**
     * Les données (couleurs etc..) de la GUI
     */
    private CheckersGameGUIData checkersGameGUIData;

    /**
     * Les données de la couche model
     */
    private CheckersGameModel checkersGameModel;

    /**
     * Le support pour le pattern Observer
     */
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * Constructeur de la classe CheckersGameControler
     *
     * @param checkersGameGUIData Les données de la GUI (couleur, taille, etc)
     * @param model               Le lien vers la couche model
     */
    public CheckersGameControler(CheckersGameGUIData checkersGameGUIData, CheckersGameModel model) {
        this.propertyChangeSupport = new PropertyChangeSupport(this);

        this.checkersGameGUIData = checkersGameGUIData;
        this.checkersGameGUIData.addPropertyChangeListener(this);

        this.checkersGameModel = model;
    }

    /**
     * Enregistre l'observer donné
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Accesseur pour la couleur des pièces noires
     *
     * @return La couleur des pièces noires
     */
    public Color getColorBlackPiece() {
        return this.checkersGameGUIData.getColorBlackPiece();
    }

    /**
     * Accesseur pour la couleur des pièces blanches
     *
     * @return La couleur des pièces blanches
     */
    public Color getColorWhitePiece() {
        return this.checkersGameGUIData.getColorWhitePiece();
    }

    /**
     * Accesser pour la couleur des cases noires
     *
     * @return La couleur des cases noires
     */
    public Color getColorBlackSquare() {
        return this.checkersGameGUIData.getColorBlackSquare();
    }

    /**
     * Accesseur pour la couleur des cases blanches
     *
     * @return La couleur des cases blanches
     */
    public Color getColorWhiteSquare() {
        return this.checkersGameGUIData.getColorWhiteSquare();
    }

    /**
     * Accesseur pour la taille du damier
     *
     * @return La taille du damier
     */
    public int getSize() {
        return this.checkersGameGUIData.getSize();
    }

    /**
     * Evènement lancé quand on clique sur une pièce
     *
     * @param piece La pièce cliquée
     */
    public void clickedPiece(JPanel piece) {
        if (checkersGameModel.checkSelectionLegality((JPanel) piece.getParent())) {
            this.propertyChangeSupport.firePropertyChange("selectedPieceGUI", null, piece);
        }
    }

    /**
     * Evènement lancé quand on clique sur une case pour y déplacer une pièce
     *
     * @param target Case sur laquelle on souhaite déplacer la pièce
     */
    public void movePiece(JPanel target) {
        ActionType actionType = checkersGameModel.movePiece(target);
        if (actionType != ActionType.NOMOVE) {
            this.propertyChangeSupport.firePropertyChange("movePiece", null, target);
        }
    }

    /**
     * Evènement lancé quand on repère un changement de propriété dans les objets qu'on écoute
     *
     * @param evt L'évènement généré
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.propertyChangeSupport.firePropertyChange(evt);

    }

    public void addCoord(JPanel case_add, int x, int y) {
        this.checkersGameModel.addCoord(case_add, new Coord(x, y));
    }

    public class ChangeColorPieceListener implements ActionListener {

        /**
         * Type de pièce dont la couleur sera changée par ce Listener
         */
        private PieceGUI.PieceColor pieceColor;

        /**
         * Constructeur du listener
         *
         * @param pieceColor
         */
        public ChangeColorPieceListener(PieceGUI.PieceColor pieceColor) {
            this.pieceColor = pieceColor;
        }

        /**
         * Appellé quand on clique sur le bouton concerné
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (this.pieceColor) {
                case BLANC:
                    Color newColorBlanc = JColorChooser.showDialog(null, "Couleur pièce blanche", getColorWhitePiece());
                    checkersGameGUIData.setColorWhitePiece(newColorBlanc);
                    break;
                case NOIR:
                    Color newColorNoir = JColorChooser.showDialog(null, "Couleur pièce noire", getColorBlackPiece());
                    checkersGameGUIData.setColorBlackPiece(newColorNoir);
                    break;
            }
        }
    }

}
