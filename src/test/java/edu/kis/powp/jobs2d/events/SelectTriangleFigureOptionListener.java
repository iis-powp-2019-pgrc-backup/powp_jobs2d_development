package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTriangleFigureOptionListener implements ActionListener {

    private List<DriverCommand> commands;


    public SelectTriangleFigureOptionListener()
    {
        commands = new ArrayList<>();
        commands.add(new SetPositionCommand(-100, -50));
        commands.add(new OperateToCommand(100, -50));
        commands.add(new OperateToCommand(0, 150));
        commands.add(new OperateToCommand(-100, -50));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, "ScalableCommand");
    }
}
