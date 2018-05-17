package fr.pinon.checkers.model;

public interface PieceModel {
    /**
     * Vérifie si un déplacement de pièce est possible
     *
     * @param targetCoord Les positions qu'on souhaite vérifier
     * @return True si le déplacement d'une pièce est possible
     */
    boolean isMoveOk(Coord targetCoord);

    /**
     * @param targetCoord Les coordonnées de la case qu'on vise
     * @return True si le déplacement en diagonale de deux cases est possible uniquement en cas de prise d'une pièce
     * adverse
     */
    boolean isMoveOkWithCatch(Coord targetCoord);

    /**
     * Récupère les coordonnées de la pièce
     *
     * @return Les coordonnées XY de la pièce (Object Coord)
     */
    Coord getCoord();

    /**
     * Récupère la position X de la pièce. Même chose que getCoord().x
     *
     * @return La composante X de la position.
     */
    int getX();

    /**
     * Récupère la position Y de la pièce. Même chose que getCoord().y
     *
     * @return La composante Y de la position.
     */
    int getY();

    /**
     * Change les coordonnées de la pièce.
     *
     * @param pieceCoord Nouvelles positions de la pièce
     */
    void setCoord(Coord pieceCoord);

    /**
     * Récupère la couleur de la pièce sous forme d'Enum
     *
     * @return La couleur de la pièce (Object PieceGUI.PieceColor)
     */
    PieceGUI.PieceColor getPieceColor();
}
