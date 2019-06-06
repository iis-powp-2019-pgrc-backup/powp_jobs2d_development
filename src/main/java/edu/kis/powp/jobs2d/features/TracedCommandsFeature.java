package edu.kis.powp.jobs2d.features;

import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.adapter.SpyDriverAdapter;

public class TracedCommandsFeature {

	private static SpyDriverAdapter spyDriverAdapter;

	public static SpyDriverAdapter getSpyDriverAdapter() {
		return spyDriverAdapter;
	}

	public static void setupTracedCommandManager() {
		spyDriverAdapter = new SpyDriverAdapter();
	}

	public static List<DriverCommand>  getTracedCommands() {
		return spyDriverAdapter.getTracedCommandsList();
	}
	
	public static void clearTracedCommands() {
		spyDriverAdapter.clearTracedCommandList();
	}
}
