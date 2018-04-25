package fr.pinon.checkers.model;

public class Pawn extends AbstractPiece {
    public Pawn(Coord coord, PieceGUI.PieceColor pieceColor) {
        super(coord, pieceColor);
    }

    @Override
    public boolean isMoveOk(Coord targetCoord) {
        boolean toReturn = false;
        switch (this.getPieceColor()) {
            case BLANC:
                toReturn = this.getY() - 1 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 1;
                break;
            case NOIR:
                toReturn = this.getY() + 1 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 1;
                break;
        }

        return toReturn;
    }

    @Override
    public boolean isMoveOkWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch) {
        return false;
    }
}
