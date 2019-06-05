package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.RecorderFeature;
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
        RecorderFeature.toggleRecording();
        if(!RecorderFeature.isRecordInProgress()) { // record has been just stopped and recorded data is already available
            DriverCommandManager driverCommandManager = CommandsFeature.getDriverCommandManager();
            driverCommandManager.setCurrentCommand(RecorderFeature.getRecordedCommands());
        }
    }
}
