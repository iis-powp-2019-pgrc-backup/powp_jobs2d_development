package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.gui.InkFillerWindow;
import edu.kis.powp.jobs2d.drivers.CountingDriver;
import edu.kis.powp.jobs2d.features.Publisher;

import javax.swing.*;

public class NoInkSubscriber implements edu.kis.powp.jobs2d.features.Subscriber {

    Job2dDriver countingDriver;

    public NoInkSubscriber(Job2dDriver countingDriver){
        this.countingDriver = countingDriver;
    }

    @Override
    public void update(String info) {
        JFrame frame = new JFrame("InputDialog Example #1");

        // prompt the user to enter their name
        String value = JOptionPane.showInputDialog(frame, "Not enough ink in reservoir. How much ink to fill?");
        CountingDriver cd = (CountingDriver)countingDriver;
        cd.addInk(Float.parseFloat(value));

        System.out.println(info);
    }
}
