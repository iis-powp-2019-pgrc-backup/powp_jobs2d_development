package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.manager.CommandHistoryUpdateObserver;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.manager.LoggerCommandChangeObserver;

public class CommandsFeature {

	private static DriverCommandManager commandManager;

	public static void setupCommandManager() {
		commandManager = new DriverCommandManager();

		LoggerCommandChangeObserver loggerObserver = new LoggerCommandChangeObserver();
		commandManager.getChangePublisher().addSubscriber(loggerObserver);

		CommandHistoryUpdateObserver commandChangeObserver = new CommandHistoryUpdateObserver();
		commandManager.getChangePublisher().addSubscriber(commandChangeObserver);
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
