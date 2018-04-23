package fr.pinon.checkers;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckersGameGUIData {

    private Color colorBlackPiece;
    private Color colorWhitePiece;
    private Color colorBlackSquare;
    private Color colorWhiteSquare;
    private int size;

    private PropertyChangeSupport propertyChangeSupport;

    public CheckersGameGUIData(Color blackPiece, Color whitePiece, Color blackSquare, Color whiteSquare, int size) {
        this.colorBlackPiece = blackPiece;
        this.colorWhitePiece = whitePiece;
        this.colorBlackSquare = blackSquare;
        this.colorWhiteSquare = whiteSquare;
        this.size = size;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public Color getColorBlackPiece() {
        return colorBlackPiece;
    }

    public void setColorBlackPiece(Color colorBlackPiece) {

        Color oldColorBlackPiece = this.colorBlackPiece;
        this.colorBlackPiece = colorBlackPiece;
        this.propertyChangeSupport.firePropertyChange(
                "colorBlackPiece",
                oldColorBlackPiece,
                this.colorBlackPiece
        );
    }

    public Color getColorWhitePiece() {
        return colorWhitePiece;
    }

    public void setColorWhitePiece(Color colorWhitePiece) {

        Color oldColorWhitePiece = this.colorWhitePiece;
        this.colorWhitePiece = colorWhitePiece;
        this.propertyChangeSupport.firePropertyChange(
                "colorWhitePiece",
                oldColorWhitePiece,
                this.colorWhitePiece
        );
    }

    public Color getColorBlackSquare() {
        return colorBlackSquare;
    }

    public void setColorBlackSquare(Color colorBlackSquare) {
        this.colorBlackSquare = colorBlackSquare;
    }

    public Color getColorWhiteSquare() {
        return colorWhiteSquare;
    }

    public void setColorWhiteSquare(Color colorWhiteSquare) {
        this.colorWhiteSquare = colorWhiteSquare;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
