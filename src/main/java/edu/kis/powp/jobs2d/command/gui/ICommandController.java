package edu.kis.powp.jobs2d.command.gui;

public interface ICommandController {

    void clearCurrentCommand();

    String getCurrentCommandString();

    void setObserversActiveOrInactive();

    void executeLastCommand();

    String getObserversListString();
}
