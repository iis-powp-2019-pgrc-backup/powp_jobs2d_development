package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.Transformations.Rotate90ToRight;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTransformation3Command implements ActionListener {
    private DriverCommandManager driverCommandManager;

    public SelectTransformation3Command(DriverCommandManager driverCommandManager) {
        this.driverCommandManager = driverCommandManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Rotate90ToRight rotate90ToRight = new Rotate90ToRight();

        DriverCommand driverCommand = rotate90ToRight.performTransformation(driverCommandManager.getCurrentCommand());

        driverCommandManager.setCurrentCommand(driverCommand);

    }
}
