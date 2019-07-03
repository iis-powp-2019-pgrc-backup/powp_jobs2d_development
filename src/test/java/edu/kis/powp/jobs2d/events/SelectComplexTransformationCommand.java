package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.Transformations.ITransform;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectComplexTransformationCommand implements ActionListener {

    List<ITransform> list;
    DriverCommandManager driverCommandManager;

    public SelectComplexTransformationCommand(List<ITransform> list, DriverCommandManager driverCommandManager) {
        this.list = list;
        this.driverCommandManager = driverCommandManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command = driverCommandManager.getCurrentCommand();
        for (ITransform x : list){
            command = x.performTransformation(command);
            driverCommandManager.setCurrentCommand(command);
        }
    }
}
