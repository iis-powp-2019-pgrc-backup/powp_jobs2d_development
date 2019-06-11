package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.MoveFeature;

public class SelectLoadSecretCommandOptionListener2 implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<DriverCommand> commands = new ArrayList<DriverCommand>();
		/*
		commands.add(new SetPositionCommand2(-20, -50, x, y));
		commands.add(new OperateToCommand2(-20, -50, x, y));
		commands.add(new SetPositionCommand2(-20, -40, x, y));
		commands.add(new OperateToCommand2(-20, 50, x, y));
		commands.add(new SetPositionCommand2(0, -50, x, y));
		commands.add(new OperateToCommand2(0, -50, x, y));
		commands.add(new SetPositionCommand2(0, -40, x, y));
		commands.add(new OperateToCommand2(0, 50, x, y));
		commands.add(new SetPositionCommand2(70, -50, x, y));
		commands.add(new OperateToCommand2(20, -50, x, y));
		commands.add(new OperateToCommand2(20, 0, x, y));
		commands.add(new OperateToCommand2(70, 0, x, y));
		commands.add(new OperateToCommand2(70, 50, x, y));
		commands.add(new OperateToCommand2(20, 50, x, y));
		*/
		
		commands.add(new SetPositionCommand(-20+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new OperateToCommand(-20+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new SetPositionCommand(-20+MoveFeature.x, -40+MoveFeature.y));
		commands.add(new OperateToCommand(-20+MoveFeature.x, 50+MoveFeature.y));
		commands.add(new SetPositionCommand(0+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new OperateToCommand(0+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new SetPositionCommand(0+MoveFeature.x, -40+MoveFeature.y));
		commands.add(new OperateToCommand(0+MoveFeature.x, 50+MoveFeature.y));
		commands.add(new SetPositionCommand(70+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new OperateToCommand(20+MoveFeature.x, -50+MoveFeature.y));
		commands.add(new OperateToCommand(20+MoveFeature.x, 0+MoveFeature.y));
		commands.add(new OperateToCommand(70+MoveFeature.x, 0+MoveFeature.y));
		commands.add(new OperateToCommand(70+MoveFeature.x, 50+MoveFeature.y));
		commands.add(new OperateToCommand(20+MoveFeature.x, 50+MoveFeature.y));
		
		
	
		

		DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
		manager.setCurrentCommand(commands, "TopSecretCommand");
	}
}