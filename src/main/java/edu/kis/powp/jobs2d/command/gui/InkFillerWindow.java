package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.CountingDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InkFillerWindow extends JFrame implements WindowComponent
{
    Job2dDriver countingDriver;
    public InkFillerWindow(Job2dDriver countingDriver)
    {
        this.countingDriver = countingDriver;

        this.setTitle("Filler");
        this.setSize(400, 400);
        Container content = this.getContentPane();
        content.setLayout(new GridBagLayout());

        JButton btnClearCommand = new JButton("Add ink");
        btnClearCommand.addActionListener((ActionEvent e) -> this.AddInk());
        content.add(btnClearCommand);

        HideIfVisibleAndShowIfHidden();
    }

    private void AddInk(){
        CountingDriver cd = (CountingDriver)countingDriver;
        cd.addInk(2000f);
        HideIfVisibleAndShowIfHidden();
    }

    @Override
    public void HideIfVisibleAndShowIfHidden()
    {
        if (this.isVisible()) {
            this.setVisible(false);
        } else {
            this.setVisible(true);
        }
    }
}
