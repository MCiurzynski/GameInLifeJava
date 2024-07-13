/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package life;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

/**
 *
 * @author golde
 */
public class Settings extends JFrame {
    private LifeFrame lifeFrame;
    private LifeProperties properties;
    
    final private FlowLayout basicLayout;
    final private FlowLayout applyLayout;

    final private JLabel cellSizeLabel;
    final private SpinnerModel cellSizeSpinnerModel;
    final private JSpinner cellSizeSpinner;
    final private JPanel cellSizePanel;
    
    final private JLabel widthLabel;
    final private SpinnerModel widthSpinnerModel;
    final private JSpinner widthSpinner;
    final private JPanel widthPanel;
    
    final private JLabel heightLabel;
    final private SpinnerModel heightSpinnerModel;
    final private JSpinner heightSpinner;
    final private JPanel heightPanel;
    
    final private JLabel waitTimeLabel;
    final private SpinnerModel waitTimeSpinnerModel;
    final private JSpinner waitTimeSpinner;
    final private JPanel waitTimePanel;

    final private JButton apply;
    final private JButton cancel;
    final private JPanel applyPanel;

    @SuppressWarnings("UnnecessaryUnboxing")
    public Settings(LifeFrame frame, LifeProperties properties) {
        super("Ustawienia");
        lifeFrame = frame;
        this.properties = properties;

        UIManager.put("TextComponent.arc", 5);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);

        basicLayout = new FlowLayout();
        basicLayout.setAlignment(FlowLayout.LEFT);
        applyLayout = new FlowLayout();
        applyLayout.setAlignment(FlowLayout.RIGHT);
        setLayout(new GridLayout(5, 1));

        cellSizeLabel = new JLabel("Cell Size");
        cellSizeSpinnerModel = new SpinnerNumberModel(properties.get("cellSize").intValue(), 1, 100, 1);
        cellSizeSpinner = new JSpinner(cellSizeSpinnerModel);
        cellSizeSpinner.setPreferredSize(new Dimension(72, 22));
        cellSizePanel = new JPanel(basicLayout);
        cellSizePanel.add(cellSizeSpinner);
        cellSizePanel.add(cellSizeLabel);
        add(cellSizePanel);
        
        widthLabel = new JLabel("Width");
        widthSpinnerModel = new SpinnerNumberModel(properties.get("width").intValue(), 1, 10000, 1);
        widthSpinner = new JSpinner(widthSpinnerModel);
        widthSpinner.setPreferredSize(new Dimension(72, 22));
        widthPanel = new JPanel(basicLayout);
        widthPanel.add(widthSpinner);
        widthPanel.add(widthLabel);
        add(widthPanel);
        
        heightLabel = new JLabel("Height");
        heightSpinnerModel = new SpinnerNumberModel(properties.get("height").intValue(), 1, 10000, 1);
        heightSpinner = new JSpinner(heightSpinnerModel);
        heightSpinner.setPreferredSize(new Dimension(72, 22));
        heightPanel = new JPanel(basicLayout);
        heightPanel.add(heightSpinner);
        heightPanel.add(heightLabel);
        add(heightPanel);
        
        waitTimeLabel = new JLabel("Wait Time");
        waitTimeSpinnerModel = new SpinnerNumberModel(properties.get("waitTime").intValue(), 1, 10000, 1);
        waitTimeSpinner = new JSpinner(waitTimeSpinnerModel);
        waitTimeSpinner.setPreferredSize(new Dimension(72, 22));
        waitTimePanel = new JPanel(basicLayout);
        waitTimePanel.add(waitTimeSpinner);
        waitTimePanel.add(waitTimeLabel);
        add(waitTimePanel);

        apply = new JButton("Zastosuj");
        apply.addActionListener((e) -> {
            int cellSize;
            int width;
            int height;
            int waitTime;
            cellSize = (int) cellSizeSpinner.getValue();
            properties.put("cellSize", cellSize);
            width = (int) widthSpinner.getValue();
            properties.put("width", width);
            height = (int) heightSpinner.getValue();
            properties.put("height", height);
            waitTime = (int) waitTimeSpinner.getValue();
            properties.put("waitTime", waitTime);
            lifeFrame.resize();
            setVisible(false);
        });
        cancel = new JButton("Anuluj");
        cancel.addActionListener((e) -> {
            setVisible(false);
        });
        applyPanel = new JPanel(applyLayout);
        applyPanel.add(apply);
        applyPanel.add(cancel);
        add(applyPanel);

        setVisible(true);

    }
}
