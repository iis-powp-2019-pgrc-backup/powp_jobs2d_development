package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Transformators.ScalableActionListener;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectScalableFigureOptionListener implements ScalableActionListener {

    private List<DriverCommand> commands;

    @Override
    public List<DriverCommand> getCommands() {
        return commands;
    }

    public SelectScalableFigureOptionListener()
    {
        commands = new ArrayList<>();
        commands.add(new SetPositionCommand(-78, 0));
        commands.add(new OperateToCommand(16, 87));
        commands.add(new OperateToCommand(57, -0));
        commands.add(new OperateToCommand(-102, -100));
        commands.add(new OperateToCommand(-78, 0));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, "ScalableCommand");
    }
}
