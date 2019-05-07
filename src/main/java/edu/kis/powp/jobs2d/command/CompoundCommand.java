package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompoundCommand implements ICompoundCommand {

    private List<DriverCommand> commandList;

    public CompoundCommand() {
        this.commandList = new ArrayList<>();
    }

    public CompoundCommand(List<DriverCommand> commandList) {
        this.commandList = commandList;
    }

    public void addComand(DriverCommand command){
        this.commandList.add(command);
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return commandList.iterator();
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : this.commandList){
            command.execute(driver);
        }
    }
}
