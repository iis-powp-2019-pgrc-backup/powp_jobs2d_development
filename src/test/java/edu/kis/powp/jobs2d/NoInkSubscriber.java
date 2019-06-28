package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.drivers.CountingDriver;

import javax.swing.*;

public class NoInkSubscriber implements edu.kis.powp.jobs2d.features.Subscriber {

    private CountingDriver countingDriver;

    public NoInkSubscriber(CountingDriver countingDriver){
        this.countingDriver = countingDriver;
    }

    @Override
    public void update(String info) {
        JFrame frame = new JFrame("InputDialog Example #1");

        String value = JOptionPane.showInputDialog(frame, "To low ink in reservoir. How much ink to fill?");
        try
        {
            countingDriver.addInk(Float.parseFloat(value));
        }
        catch(Exception e)
        {
            update(info);
            return;
        }
        

        System.out.println(info);
    }
}
