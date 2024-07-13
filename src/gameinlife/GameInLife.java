/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gameinlife;

import javax.swing.SwingUtilities;
import life.LifeFrame;

/**
 *
 * @author golde
 */
public class GameInLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            new LifeFrame();
        });
    }
    
}
