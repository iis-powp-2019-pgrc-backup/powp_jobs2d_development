package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.List;

public interface GenerateCommands {

    List<DriverCommand> CommandsToDraw(String s);
}
