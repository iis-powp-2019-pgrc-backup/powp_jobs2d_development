package edu.kis.powp.jobs2d.command.manager;

import java.util.List;

public interface CommandParser {

    void parseCommand(String inputCommand);
    void clearCommands();
}
