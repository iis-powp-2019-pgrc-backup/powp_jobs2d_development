package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.manager.CommandInsertObserver;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.manager.LoggerCommandChangeObserver;

public class CommandsFeature {

	private static DriverCommandManager commandManager;

	public static void setupCommandManager() {
		commandManager = new DriverCommandManager();

		LoggerCommandChangeObserver loggerObserver = new LoggerCommandChangeObserver();
		commandManager.getChangePublisher().addSubscriber(loggerObserver);
		
		CommandInsertObserver commandObserver = new CommandInsertObserver();
		commandManager.getChangePublisher().addSubscriber(commandObserver);
	}

	/**
	 * Get manager of application driver command.
	 * 
	 * @return plotterCommandManager.
	 */
	public static DriverCommandManager getDriverCommandManager() {
		return commandManager;
	}
}
