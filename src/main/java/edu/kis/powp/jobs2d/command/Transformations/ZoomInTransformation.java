package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.*;

public class ZoomInTransformation implements ITransform {

    private Integer value;

    public ZoomInTransformation(Integer value) {
        this.value = value;
    }

    @Override
    public CompoundCommand performTransformation(CompoundCommand compoundCommand) {
        CompoundCommand newCompoundCommand = new CompoundCommand();
        DriverCommand newCommand = null;
        while(compoundCommand.iterator().hasNext()){
            DriverCommand command = compoundCommand.iterator().next();
            if (command instanceof OperateToCommand)
                newCommand = new OperateToCommand(((OperateToCommand) command).getPosX() + value, ((OperateToCommand) command).getPosY() + value);
            else if (command instanceof SetPositionCommand)
                newCommand = new SetPositionCommand(((SetPositionCommand) command).getPosX() + value, ((SetPositionCommand) command).getPosY() + value);
            newCompoundCommand.addComand(newCommand);
        }
        return newCompoundCommand;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
