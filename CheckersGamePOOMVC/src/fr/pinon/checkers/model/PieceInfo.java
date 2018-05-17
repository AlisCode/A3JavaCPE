package fr.pinon.checkers.model;

public class PieceInfo {

    private Coord coords;
    private PieceGUI.PieceColor color;

    public PieceInfo(Coord coords, PieceGUI.PieceColor col) {
        this.coords = coords;
        this.color = col;
    }

    public static PieceInfo fromModel(PieceModel pieceModel) {
        return new PieceInfo(pieceModel.getCoord(), pieceModel.getPieceColor());
    }

    public Coord getCoords() {
        return this.coords;
    }

    public PieceGUI.PieceColor getColor() {
        return this.color;
    }
}
