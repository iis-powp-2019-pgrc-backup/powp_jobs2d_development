package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CompoundCommand implements ICompoundCommand {

    private List<DriverCommand> driverCommands = new ArrayList<>();

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

}
