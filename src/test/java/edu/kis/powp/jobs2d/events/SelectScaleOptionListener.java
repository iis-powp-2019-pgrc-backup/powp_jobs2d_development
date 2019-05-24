package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Transformators.Scaler;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectScaleOptionListener implements ActionListener {

    private double factor;

    public SelectScaleOptionListener(double factor)
    {
        this.factor = factor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandsFeature.getDriverCommandManager().getCurrentCommand().accept(new Scaler(factor));
    }
}
