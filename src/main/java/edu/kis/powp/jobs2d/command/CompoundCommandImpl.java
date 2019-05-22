package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.*;

public class CompoundCommandImpl implements ICompoundCommand {

    private List<DriverCommand> driverCommands;

    public CompoundCommandImpl(List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    public CompoundCommandImpl(DriverCommand... driverCommands) {
        this(Arrays.asList(driverCommands));
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return Collections.unmodifiableList(driverCommands).iterator();
    }

    @Override
    public void execute(Job2dDriver driver) {
        for(DriverCommand driverCommand: driverCommands) {
            driverCommand.execute(driver);
        }
    }
}
