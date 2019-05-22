package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.*;

/**
 * CompoundCommandImpl implementation of ICompoundCommand providing both execute batch
 * and iterator.
 */
public class CompoundCommandImpl implements ICompoundCommand {

    private List<DriverCommand> driverCommands;

    /**
     * Constructor for class which can take list of input commands.
     * @param driverCommands list of DriverCommand
     */
    public CompoundCommandImpl(List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    /**
     * Constructor for class which can take arbitrary number of input commands.
     * @param driverCommands vararg of DriverCommand
     *
     */
    public CompoundCommandImpl(DriverCommand... driverCommands) {
        this(Arrays.asList(driverCommands));
    }

    /**
     * Delegate iterator to base Java collection (immutable list).
     * @return iterator for driverCommands list
     */
    @Override
    public Iterator<DriverCommand> iterator() {
        return Collections.unmodifiableList(driverCommands).iterator();
    }

    /**
     * Execute sequence for every driverCommand stored in class.
     * @param driver driver.
     */
    @Override
    public void execute(Job2dDriver driver) {
        for(DriverCommand driverCommand: driverCommands) {
            driverCommand.execute(driver);
        }
    }
}
