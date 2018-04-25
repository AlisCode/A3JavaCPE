package fr.pinon.checkers.model;

public class Queen extends AbstractPiece {

    public Queen(Coord coord, PieceGUI.PieceColor pieceColor) {
        super(coord, pieceColor);
    }

    @Override
    public boolean isMoveOk(Coord targetCoord) {
        return false;
    }

    @Override
    public boolean isMoveOkWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch) {
        return false;
    }
}
