/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author golde
 */
public class LifeFrame extends JFrame {

    private LifePanel panel;
    private LifeBoard board;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem settings;
    private LifeProperties properties;
    private JScrollPane scrollPane;
    private JButton control;
    private Thread nextThread;

    public LifeFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        properties = new LifeProperties();

        control = new JButton("Start");
        control.addActionListener((e) -> {
            if (nextThread == null) {
                nextThread = new NextThread(panel, board, properties.get("waitTime"));
                nextThread.start();
                control.setText("Stop");
            } else {
                nextThread.interrupt();
                nextThread = null;
                control.setText("Start");
            }
        });

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        settings = new JMenuItem();
        settings.setText("Settings");
        settings.addActionListener((e) -> {
            new Settings(this, properties);
        });
        menu.add(settings);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(control, BorderLayout.NORTH);
        createBoard();
        setVisible(true);
    }

    final public void createBoard() {
        board = new LifeBoard(properties);
        panel = new LifePanel(board, properties);
        scrollPane = new JScrollPane(panel);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int cellX = e.getX() / properties.get("cellSize");
                int cellY = e.getY() / properties.get("cellSize");
                if (cellX >= properties.get("width") || cellY >= properties.get("height")) {
                    return;
                }
                if (e.getButton() == 1) {
                    board.setState(cellX, cellY, !board.isAlive(cellX, cellY));
                }
                if (e.getButton() == 3) {
                    for (int i = cellX - 5; i < cellX + 5 && i < board.getWidth(); i++) {
                        if (i < 0) {
                            i = 0;
                        }
                        for (int j = cellY - 5; j < cellY + 5 && j < board.getHeight(); j++) {
                            if (j < 0) {
                                j = 0;
                            }
                            if (Math.random() < 0.5) {
                                board.setState(i, j, true);
                            } else {
                                board.setState(i, j, false);
                            }
                        }
                    }
                }
                validate();
                repaint();
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        validate();
        repaint();
    }

    public void resize() {
        if (nextThread != null)
            nextThread.interrupt();
        nextThread = null;
        control.setText("Start");
        panel.resize();
    }
}
