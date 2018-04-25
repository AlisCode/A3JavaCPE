package fr.pinon.checkers.model;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
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
     * Map hash JPanel case -> coordonnées de la case
     */
    private HashMap<Integer, Coord> coordHashMap;

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
        this.coordHashMap = new HashMap<>();

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

    public void addCoord(JPanel case_add, Coord coord) {
        this.coordHashMap.put(case_add.hashCode(), coord);
    }

    /**
     * Vérifie si la séléction est légale (si on a séléctionné un pion qui est jouable). Si oui, change this.pieceToMove
     * en conséquence
     *
     * @param piece_panel Le JPanel de la case qu'on a séléctionné
     * @return True si la sélection est légale, false sinon.
     */
    public boolean checkSelectionLegality(JPanel piece_panel) {
        PieceModel piece = this.findPiece(this.coordHashMap.get(piece_panel.hashCode()));
        if (piece != null && piece.getPieceColor() == this.currentColor) {
            this.pieceToMove = piece;
            return true;
        }
        return false;
    }

    public ActionType movePiece(JPanel dest) {
        Coord coord = this.coordHashMap.get(dest.hashCode());
        return this.doMovePiece(coord);
    }

    private ActionType doMovePiece(Coord dest_coord) {

        if (this.pieceToMove == null) {
            return ActionType.NOMOVE;
        }

        // Vérifie si on a déjà une pièce ou non aux coordonnées voulues
        PieceModel piece = this.findPiece(dest_coord);
        if (piece == null) {
            // Vérifie le cas où on peut bouger sans prendre de pion
            if (this.pieceToMove.isMoveOk(dest_coord)) {
                this.pieceToMove.setCoord(dest_coord);
                // Affiche le modèle pour vérifier qu'on a bien bougé les pièces correspondantes
                System.out.println(this.getListAsString());
                return ActionType.SIMPLEMOVE;
            } else if (this.pieceToMove.isMoveOkWithCatch(dest_coord, 0, 0, true)) {
                // TODO: Gérer le cas où on bouge et prends un pion ici
            }
        }

        // Si aucun mouvement n'est possible, on retourne NOMOVE
        return ActionType.NOMOVE;
    }

    private PieceModel findPiece(Coord coord) {
        Optional<PieceModel> opt = this.pieceList.stream().filter(p -> p.getCoord().equals(coord)).findFirst();
        return opt.orElse(null);
    }
}
