package edu.kis.powp.jobs2d.command.gui.transformations;

import edu.kis.powp.appbase.gui.WindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransformManagerWindow extends JFrame implements WindowComponent
{
    public TransformManagerWindow(TransformManager transformManager)
    {
        setTitle("Transform Manager");
        setSize(300, 200);

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4, 2, 3, 3);

        JTextArea xTransform = new JTextArea("X: ");
        xTransform.setEditable(false);
        JTextField xTransformField = new JTextField(String.valueOf(transformManager.getTransformX()));
        xTransformField.setInputVerifier(new NumberInputVerifier());

        JTextArea yTransform = new JTextArea("Y: ");
        yTransform.setEditable(false);
        JTextField yTransformField = new JTextField(String.valueOf(transformManager.getTransformY()));
        yTransformField.setInputVerifier(new NumberInputVerifier());

        JTextArea rotation = new JTextArea("Rotation angle: ");
        yTransform.setEditable(false);
        JTextField rotationAngle = new JTextField(String.valueOf(transformManager.getRotation()));
        rotationAngle.setInputVerifier(new NumberInputVerifier(true));

        JButton setButton = new JButton("Update transformation");
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int transformX = Integer.parseInt(xTransformField.getText());
                    int transformY = Integer.parseInt(yTransformField.getText());
                    int angle = Integer.parseInt(rotationAngle.getText());
                    transformManager.UpdateTransform(transformX, transformY, angle);
                }
                catch(Exception exception) { }
            }
        });

        panel.setLayout(layout);
        panel.add(xTransform);
        panel.add(xTransformField);
        panel.add(yTransform);
        panel.add(yTransformField);
        panel.add(rotation);
        panel.add(rotationAngle);
        panel.add(setButton);

        add(panel);
    }

    @Override
    public void HideIfVisibleAndShowIfHidden()
    {
        if (isVisible())
            setVisible(false);
        else
            setVisible(true);
    }
}
