package fr.pinon.checkers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public class CheckersGameModel {

    /**
     * La liste des pièces
     */
    private LinkedList<PieceModel> pieceList;

    /**
     * La pièce à déplacer
     */
    private PieceModel pieceToMove;

    /**
     * La pièce à prendre
     */
    private PieceModel pieceToTake;

    /**
     * Coordonnées de la dernière pièce capturée
     */
    private Coord lastRevoveCoord;

    private PieceGUI.PieceColor currentColor, unCurrentColor;

    /**
     * Taille du damier
     */
    private int size;

    public CheckersGameModel(Coord[] newBlackCoords, Coord[] newWhiteCoords, int size, PieceGUI.PieceColor color) {
        this.pieceList = new LinkedList<PieceModel>();

        this.pieceList.addAll(Arrays.stream(newWhiteCoords).map(coord -> new Pawn(coord, PieceGUI.PieceColor.BLANC)).collect(Collectors.toList()));
        this.pieceList.addAll(Arrays.stream(newBlackCoords).map(coord -> new Pawn(coord, PieceGUI.PieceColor.NOIR)).collect(Collectors.toList()));

        this.pieceToMove = null;
        this.pieceToTake = null;
        this.lastRevoveCoord = null;
        this.currentColor = color;
        this.unCurrentColor = null;
        this.size = size;

        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CheckersGameModel{" +
                "pieceList=\n" + this.getListAsString() +
                ", pieceToMove=" + pieceToMove +
                ", pieceToTake=" + pieceToTake +
                ", lastRevoveCoord=" + lastRevoveCoord +
                ", currentColor=" + currentColor +
                ", unCurrentColor=" + unCurrentColor +
                ", size=" + size +
                '}';
    }

    public String getListAsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            builder.append("\t\t").append(i);
        }

        builder.append('\n');

        for (int y = 0; y < this.size; y++) {
            builder.append(y);
            for (int x = 0; x < this.size; x++) {
                builder.append("\t" + "--");
                int finalX = x;
                int finalY = y;
                Optional<PieceModel> piece = pieceList.stream().filter(p -> p.getX() == finalX && p.getY() == finalY).findFirst();
                if (piece.isPresent()) {
                    switch (piece.get().getPieceColor()) {
                        case BLANC:
                            builder.append('B');
                            break;
                        case NOIR:
                            builder.append('N');
                            break;
                    }
                } else {
                    builder.append('-');
                }
                builder.append("--");
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    private PieceModel findPiece(Coord coord) {
        return this.pieceList.stream().filter(p -> p.getCoord().equals(coord)).findFirst().get();
    }
}
