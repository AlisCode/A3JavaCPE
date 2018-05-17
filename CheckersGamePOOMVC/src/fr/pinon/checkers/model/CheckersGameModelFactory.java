package fr.pinon.checkers.model;

import java.util.ArrayList;
import java.util.List;

public class CheckersGameModelFactory {

    public List<PieceModel> createPieceList() {
        return new ArrayList<PieceModel>();
    }

    public int getLength() {
        return 0;
    }

    public PieceGUI.PieceColor getBeginColor() {
        return PieceGUI.PieceColor.BLANC;
    }
}
