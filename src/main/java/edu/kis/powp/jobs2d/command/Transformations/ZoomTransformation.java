package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class ZoomTransformation implements ITransform {

    private float value;

    public ZoomTransformation(Integer value) {
        this.value = value;
    }

    @Override
    public CompoundCommand performTransformation(CompoundCommand compoundCommand) {
        CompoundCommand newCompoundCommand = new CompoundCommand();
        DriverCommand newCommand = null;
        while(compoundCommand.iterator().hasNext()){
            DriverCommand command = compoundCommand.iterator().next();
            if (command instanceof OperateToCommand)
                newCommand = new OperateToCommand(
                        (int) (((OperateToCommand) command).getPosX() * value),
                        (int) (((OperateToCommand) command).getPosY() * value));
            else if (command instanceof SetPositionCommand)
                newCommand = new SetPositionCommand(
                        (int)(((SetPositionCommand) command).getPosX() * value),
                        (int)(((SetPositionCommand) command).getPosY() * value));
            newCompoundCommand.addComand(newCommand);
        }
        return newCompoundCommand;
    }

    public float getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
