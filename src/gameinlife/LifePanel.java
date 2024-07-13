/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

/**
 *
 * @author golde
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LifePanel extends JPanel {

    private LifeProperties properties;
    private LifeBoard board;

    public LifePanel(LifeBoard b, LifeProperties properties) {
        super();
        board = b;
        this.properties = properties;
        setPreferredSize(new Dimension(properties.get("width") * properties.get("cellSize"), properties.get("height") * properties.get("cellSize")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = properties.get("cellSize");
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.isAlive(i, j)) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }

    public void resize() {
        board.resize();
        setPreferredSize(new Dimension(properties.get("width") * properties.get("cellSize"), properties.get("height") * properties.get("cellSize")));
        validate();
        repaint();
    }
}
