package fr.pinon.checkers.vue;

import javax.swing.*;
import java.awt.*;

public class SquareGUI extends JPanel {

    /**
     * Variable statique définissant la couleur de la bordure
     */
    private static Color COLOR_BORDER = Color.darkGray;

    /**
     * Le champ définissant la couleur de la case
     */
    private Color color;

    /**
     * Constructeur de la classe SquareGUI
     *
     * @param col La couleur de la case
     */
    public SquareGUI(Color col) {
        super(new BorderLayout());
        this.color = col;
        this.setBackground(col);
    }

    /**
     * Affiche la case avec sa bordure dans le composant JPanel
     *
     * @param g Les graphics sur lesquels on va dessiner
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(SquareGUI.COLOR_BORDER);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(this.color);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
    }

}
