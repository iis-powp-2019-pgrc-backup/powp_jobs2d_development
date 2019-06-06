package edu.kis.powp.jobs2d.features;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;

public class TracedCommandsFeature {

	static List<DriverCommand> tracedCommandsList;

	public static void setupTracedCommandManager() {
		tracedCommandsList = new ArrayList<DriverCommand>();;
	}

	public static List<DriverCommand>  getTracedCommands() {
		return tracedCommandsList;
	}
}
