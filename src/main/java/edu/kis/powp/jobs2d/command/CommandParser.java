package edu.kis.powp.jobs2d.command;

import java.util.List;

public interface CommandParser {
    List<DriverCommand> createCommansFromString(String s);
}
