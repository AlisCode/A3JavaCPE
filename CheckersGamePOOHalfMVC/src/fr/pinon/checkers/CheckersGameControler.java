package fr.pinon.checkers;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckersGameControler implements PropertyChangeListener {

    /**
     * Les données (couleurs etc..) de la GUI
     */
    private CheckersGameGUIData checkersGameGUIData;

    /**
     * Le support pour le pattern Observer
     */
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * Constructeur de la classe CheckersGameControler
     *
     * @param checkersGameGUIData
     */
    public CheckersGameControler(CheckersGameGUIData checkersGameGUIData) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.checkersGameGUIData.addPropertyChangeListener(this);
    }

    /**
     * Enregistre l'observer donné
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public Color getColorBlackPiece() {
        return this.checkersGameGUIData.getColorBlackPiece();
    }

    public Color getColorWhitePiece() {
        return this.checkersGameGUIData.getColorWhitePiece();
    }

    public Color getColorBlackSquare() {
        return this.checkersGameGUIData.getColorBlackSquare();
    }

    public Color getColorWhiteSquare() {
        return this.checkersGameGUIData.getColorWhiteSquare();
    }

    public int getSize() {
        return this.checkersGameGUIData.getSize();
    }

    public void clickedPiece(JPanel piece) {
        this.propertyChangeSupport.firePropertyChange("selectedPieceGUI", null, piece);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.propertyChangeSupport.firePropertyChange(evt);
    }
}
