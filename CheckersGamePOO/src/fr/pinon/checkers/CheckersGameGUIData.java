package fr.pinon.checkers;

import java.awt.*;

public class CheckersGameGUIData {

    private Color colorBlackPiece;
    private Color colorWhitePiece;
    private Color colorBlackSquare;
    private Color colorWhiteSquare;
    private int size;

    public CheckersGameGUIData(Color blackPiece, Color whitePiece, Color blackSquare, Color whiteSquare, int size) {
        this.colorBlackPiece = blackPiece;
        this.colorWhitePiece = whitePiece;
        this.colorBlackSquare = blackSquare;
        this.colorWhiteSquare = whiteSquare;
        this.size = size;
    }

    public Color getColorBlackPiece() {
        return colorBlackPiece;
    }

    public void setColorBlackPiece(Color colorBlackPiece) {
        this.colorBlackPiece = colorBlackPiece;
    }

    public Color getColorWhitePiece() {
        return colorWhitePiece;
    }

    public void setColorWhitePiece(Color colorWhitePiece) {
        this.colorWhitePiece = colorWhitePiece;
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
