package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectRecordedFigureOptionListener implements ActionListener {
    private DriverManager driverManager;

    public SelectRecordedFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
