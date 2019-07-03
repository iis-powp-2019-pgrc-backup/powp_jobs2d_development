package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import edu.kis.powp.jobs2d.command.Transformations.VerticalMirrorTransformation;

import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTransformation2Command implements ActionListener {
    private DriverCommandManager driverCommandManager;

    public SelectTransformation2Command(DriverCommandManager driverCommandManager) {
        this.driverCommandManager = driverCommandManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, -0));
        commands.add(new OperateToCommand(-10, -40));
        commands.add(new SetPositionCommand(-5, -35));
        commands.add(new OperateToCommand(-30, 30));
        commands.add(new SetPositionCommand(0, -10));
        commands.add(new OperateToCommand(0, -20));
        commands.add(new SetPositionCommand(10, -40));
        commands.add(new OperateToCommand(10, 20));

        CompoundCommand compoundCommand1 = new CompoundCommand(commands);


        VerticalMirrorTransformation transformation = new VerticalMirrorTransformation();

        CompoundCommand compoundCommand2 = transformation.performTransformation(compoundCommand1);

        List<DriverCommand> list = new ArrayList<>();
        compoundCommand2.iterator().forEachRemaining(list::add);


        driverCommandManager.setCurrentCommand(list,"vertical mirror transformations");

    }
}