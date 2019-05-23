package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CompoundCommand implements ICompoundCommand {

    private List<DriverCommand> driverCommands = new ArrayList<>();
    private String name;

    public CompoundCommand(String name, List<DriverCommand> commandList) {
        this.name = name;
        driverCommands = commandList;
    }

    public void addCommand(DriverCommand command) {
        driverCommands.add(command);
    }

    @Override
    public void execute(Job2dDriver driver) {
        driverCommands.forEach((c) -> c.execute(driver));
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return driverCommands.iterator();
    }

    @Override
    public String toString() {
        return name;
    }

}
