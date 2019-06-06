package edu.kis.powp.jobs2d.command.manager;

import java.util.ArrayList;
import java.util.List;

public interface CommandParser {

    List<String> commandLists =  new ArrayList<>();

    void addCommand(String input);
    void parseCommand();
    void clearCommands();
}
