/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

/**
 *
 * @author golde
 */
public class LifeBoard {
    private LifeProperties properties;
    private boolean [][] board;
    
    public LifeBoard(LifeProperties properties) {
        this.properties = properties;
        board = new boolean[properties.get("width")][properties.get("height")];
    }
    
    public boolean isAlive(int x, int y) {
        return board[x][y];
    }
    
    public void setState(int x, int y, boolean a) {
        board[x][y] = a;
    }
    
    public int getWidth() {
        return properties.get("width");
    }
    
    public int getHeight() {
        return properties.get("height");
    }
    
    public void next() {
        boolean[][] tmp = new boolean[properties.get("width")][properties.get("height")];
        for (int i = 0; i < properties.get("width"); i++) {
            for (int j = 0; j < properties.get("height"); j++) {
                if (board[i][j]) {
                    if (neighbor(i, j) >= 2 && neighbor(i, j) <= 3) {
                        tmp[i][j] = true;
                    } else {
                        tmp[i][j] = false;
                    }
                } else {
                    if (neighbor(i, j) == 3) {
                        tmp[i][j] = true;
                    } else {
                        tmp[i][j] = false;
                    }
                }
            }
        }
        board = tmp;
    }
    
    private int neighbor(int x, int y) {
        int n = 0;
        int[] a = {0, 0, -1, -1, -1, 1, 1, 1};
        int[] b = {1, -1, 1, 0, -1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            if (x + a[i] < 0 || x + a[i] >= board.length) {
                continue;
            }
            if (y + b[i] < 0 || y + b[i] >= board.length) {
                continue;
            }
            if (board[x + a[i]][y + b[i]]) {
                n++;
            }
        }
        return n;
    }
    
    public void resize() {
        board = new boolean[properties.get("width")][properties.get("height")];
    }
}
