package fr.pinon.checkers.model;

import fr.pinon.checkers.model.Coord;
import fr.pinon.checkers.model.PieceGUI;
import fr.pinon.checkers.model.PieceModel;

public abstract class AbstractPiece implements PieceModel {
    private Coord coordinates;
    private PieceGUI.PieceColor pieceColor;

    public AbstractPiece(Coord coordinates, PieceGUI.PieceColor pieceColor) {
        this.coordinates = coordinates;
        this.pieceColor = pieceColor;
    }

    public abstract boolean isMoveOk(Coord targetCoord);

    public abstract boolean isMoveOkWithCatch(Coord targetCoord);

    @Override
    public Coord getCoord() {
        return this.coordinates;
    }

    @Override
    public int getX() {
        return this.coordinates.getX();
    }

    @Override
    public int getY() {
        return this.coordinates.getY();
    }

    @Override
    public void setCoord(Coord pieceCoord) {
        this.coordinates = pieceCoord;
    }

    @Override
    public PieceGUI.PieceColor getPieceColor() {
        return this.pieceColor;
    }


}
