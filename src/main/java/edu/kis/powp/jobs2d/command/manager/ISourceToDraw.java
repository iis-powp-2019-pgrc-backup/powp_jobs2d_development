package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.List;

public interface ISourceToDraw {

    List<DriverCommand> CommandsToDraw(String s);
}
