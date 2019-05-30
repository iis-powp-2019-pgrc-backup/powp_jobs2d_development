package edu.kis.powp.jobs2d.command.gui.transformations;

import javax.swing.*;

public class NumberInputVerifier extends InputVerifier
{
    private boolean checkAngle;

    NumberInputVerifier(boolean checkAngle)
    {
        this.checkAngle = checkAngle;
    }

    NumberInputVerifier()
    {
        checkAngle = false;
    }

    public boolean verify(JComponent input)
    {
        JTextField field = (JTextField)input;

        try
        {
            int x = Integer.parseInt(field.getText());
            if (checkAngle && (x < 0 || x > 360))
                return false;

        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
}
