package fr.pinon.checkers.model;

public class Pawn extends AbstractPiece {
    public Pawn(Coord coord, PieceGUI.PieceColor pieceColor) {
        super(coord, pieceColor);
    }

    @Override
    public boolean isMoveOk(Coord targetCoord) {
        switch (this.getPieceColor()) {
            case BLANC:
                return this.getY() - 1 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 1;
            case NOIR:
                return this.getY() + 1 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 1;
        }

        return false;
    }

    @Override
    public boolean isMoveOkWithCatch(Coord targetCoord) {
        switch (this.getPieceColor()) {
            case BLANC:
                return this.getY() - 2 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 2;
            case NOIR:
                return this.getY() + 2 == targetCoord.getY() && Math.abs(this.getX() - targetCoord.getX()) == 2;
        }

        return false;
    }
}
