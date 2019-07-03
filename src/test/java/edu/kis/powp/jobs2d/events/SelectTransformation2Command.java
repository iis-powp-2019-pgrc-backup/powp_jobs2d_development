package edu.kis.powp.jobs2d.events;


import edu.kis.powp.jobs2d.command.DriverCommand;


import edu.kis.powp.jobs2d.command.Transformations.VerticalMirrorTransformation;

import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTransformation2Command implements ActionListener {
    private DriverCommandManager driverCommandManager;

    public SelectTransformation2Command(DriverCommandManager driverCommandManager) {
        this.driverCommandManager = driverCommandManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        DriverCommand driverCommand = driverCommandManager.getCurrentCommand();

        VerticalMirrorTransformation transformation = new VerticalMirrorTransformation();

        DriverCommand command = transformation.performTransformation(driverCommand);



        driverCommandManager.setCurrentCommand(command);

    }
}