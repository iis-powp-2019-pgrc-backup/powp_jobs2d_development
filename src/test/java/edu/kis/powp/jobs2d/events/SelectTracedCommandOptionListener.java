package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

public class SelectTracedCommandOptionListener implements ActionListener {

	List<DriverCommand> tracedCommandsList;
	
	public SelectTracedCommandOptionListener(List<DriverCommand> commands) {
		this.tracedCommandsList = commands;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
		manager.setCurrentCommand(tracedCommandsList, "TracedCommand");
	}
}