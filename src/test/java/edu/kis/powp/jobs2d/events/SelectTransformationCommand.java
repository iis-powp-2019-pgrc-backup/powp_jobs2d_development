package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import edu.kis.powp.jobs2d.command.Transformations.ZoomTransformation;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTransformationCommand implements ActionListener {
    private DriverCommandManager driverCommandManager;

    public SelectTransformationCommand(DriverCommandManager driverCommandManager) {
        this.driverCommandManager = driverCommandManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //DriverCommand driverCommand = driverCommandManager.getCurrentCommand();

        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(-20, -50));
        commands.add(new OperateToCommand(-20, -50));
        commands.add(new SetPositionCommand(-20, -40));
        commands.add(new OperateToCommand(-20, 50));
        commands.add(new SetPositionCommand(0, -50));
        commands.add(new OperateToCommand(0, -50));
        commands.add(new SetPositionCommand(0, -40));
        commands.add(new OperateToCommand(0, 50));
        commands.add(new SetPositionCommand(70, -50));
        commands.add(new OperateToCommand(20, -50));
        commands.add(new OperateToCommand(20, 0));
        commands.add(new OperateToCommand(70, 0));
        commands.add(new OperateToCommand(70, 50));
        commands.add(new OperateToCommand(20, 50));

        CompoundCommand compoundCommand1 = new CompoundCommand(commands);

        ZoomTransformation zoomTransformation = new ZoomTransformation(10);

        CompoundCommand compoundCommand2 = zoomTransformation.performTransformation(compoundCommand1);

        List<DriverCommand> list = new ArrayList<>();
        compoundCommand2.iterator().forEachRemaining(list::add);

       driverCommandManager.setCurrentCommand(list,"zoom");



    }
}
