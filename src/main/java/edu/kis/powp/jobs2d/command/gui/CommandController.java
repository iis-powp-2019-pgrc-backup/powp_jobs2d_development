package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class CommandController implements ICommandController {

    private final DriverManager driverManager;
    private DriverCommandManager commandManager;
    private boolean turnedOn = false;
    private List<Subscriber> observersList = new ArrayList<>();
    private String observerListString;

    public CommandController(DriverCommandManager commandManager, DriverManager driverManager){
        this.commandManager = commandManager;
        this.driverManager = driverManager;
    }

    @Override public void clearCurrentCommand() {
        commandManager.clearCurrentCommand();
    }

    @Override public String getCurrentCommandString() {
        return commandManager.getCurrentCommandString();
    }

    @Override public void setObserversActiveOrInactive() {
        if (turnedOn) {
            turnedOn = false;
            for (int i = 0; i < observersList.size(); i++) {
                commandManager.getChangePublisher().addSubscriber(observersList.get(i));
            }
            observersList.clear();
        } else {
            turnedOn = true;
            observersList.addAll(commandManager.getChangePublisher().getSubscribers());
            commandManager.getChangePublisher().clearObservers();
        }
    }

    @Override public void executeLastCommand() {
         commandManager.returnLastCommand().execute(driverManager.getCurrentDriver());
    }

    @Override public String getObserversListString() {
        observerListString = "";
        List<Subscriber> commandChangeSubscribers = commandManager.getChangePublisher().getSubscribers();
        for (Subscriber observer : commandChangeSubscribers) {
            observerListString += observer.toString() + System.lineSeparator();
        }
        if (commandChangeSubscribers.isEmpty())
            observerListString = "No observers loaded";
        return observerListString;
    }

}
