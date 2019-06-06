package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.CustomizableLine;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomizableLineOptionWindow {

    public static JFrame getFrame(){
        JFrame frame = new JFrame("Customizable Line Options");
        frame.setLayout(new GridLayout(4, 1));
        frame.show();
        Dimension dimension = new Dimension(550, 250);
        frame.setSize(dimension);
        frame.setResizable(false);

        Map<String, Color> colorMap = new HashMap<>();
        String[] colorsNames = {"Black", "Magenta", "Orange", "Pink", "Blue", "Yellow", "Red"};
        Color[] colors = {Color.BLACK, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.BLUE, Color.YELLOW, Color.RED};

        for(int i = 0; i < colors.length; i++){
            colorMap.put(colorsNames[i], colors[i]);
        }

        JComboBox colorList = new JComboBox(colorMap.keySet().stream().toArray());
        colorList.addItemListener(itemEvent -> CustomizableLine.getInstance().setColor(colorMap.get(itemEvent.getItem())));

        JCheckBox dottedCheckBox = new JCheckBox();
        dottedCheckBox.setText("Dotted");
        dottedCheckBox.addActionListener(e -> CustomizableLine.getInstance().setDotted(dottedCheckBox.isEnabled()));

        CustomizableLine.getInstance().setColor(colorMap.get(colorList.getSelectedItem()));

        JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setMajorTickSpacing(1);

        thicknessSlider.addChangeListener(e -> CustomizableLine.getInstance().setThickness(thicknessSlider.getValue()));

        JLabel label = new JLabel();
        label.setText("Thickness");

        frame.add(label);
        frame.add(thicknessSlider);
        frame.add(colorList);
        frame.add(dottedCheckBox);
        frame.setLocation(900, 150);

        return frame;
    }

}
