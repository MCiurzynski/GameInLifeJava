/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

import java.util.TreeMap;

/**
 *
 * @author golde
 */
public class LifeProperties extends TreeMap<String, Integer> {
    public LifeProperties() {
        put("cellSize", 10);
        put("waitTime", 200);
        put("height", 100);
        put("width", 100);
    }
}
