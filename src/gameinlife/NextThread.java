/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

/**
 *
 * @author golde
 */
public class NextThread extends Thread {
    private LifePanel panel;
    private LifeBoard board;
    private int time;
    
    public NextThread(LifePanel panel, LifeBoard board, int time) {
        this.panel = panel;
        this.board = board;
        this.time = time;
        setDaemon(true);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(time);
            }
            catch (InterruptedException ex) {
                break;
            }
            board.next();
            panel.validate();
            panel.repaint();
        }
    }
}
