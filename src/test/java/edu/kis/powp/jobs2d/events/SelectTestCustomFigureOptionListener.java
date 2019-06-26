package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.MoveFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectTestCustomFigureOptionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        List<DriverCommand> commands = new ArrayList<DriverCommand>();
        		commands.add(new SetPositionCommand(-100, 0));
        		commands.add(new OperateToCommand(100, 0));
        		commands.add(new OperateToCommand(-100, 150));
        		commands.add(new OperateToCommand(100,150));

        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
		manager.setCurrentCommand(commands, "ToplolCommand");
    }
}