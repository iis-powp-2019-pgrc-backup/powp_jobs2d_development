package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.observer.Subscriber;

public class CommandHistoryUpdateObserver implements Subscriber {
    @Override
    public void update() {
        DriverCommandManager driverCommandManager = CommandsFeature.getDriverCommandManager();
        if(CommandHistory.logMode)
            CommandHistory.addEntry(driverCommandManager.getCommandList(),driverCommandManager.getCommandName());
    }
}
