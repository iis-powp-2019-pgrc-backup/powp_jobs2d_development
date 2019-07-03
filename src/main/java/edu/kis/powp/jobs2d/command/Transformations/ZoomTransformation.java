
package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.*;

import java.util.Iterator;

public class ZoomTransformation implements ITransform {

    private float value;

    public ZoomTransformation(Integer value) {
        this.value = value;
    }

    @Override
    public DriverCommand performTransformation(DriverCommand command) {
        CompoundCommand compoundCommand = new CompoundCommand();
        if (command instanceof OperateToCommand)
            return new OperateToCommand(
                    (int) (((OperateToCommand) command).getPosX() * value),
                    (int) (((OperateToCommand) command).getPosY() * value));
        else if (command instanceof SetPositionCommand)
            return new SetPositionCommand(
                    (int) (((SetPositionCommand) command).getPosX() * value),
                    (int) (((SetPositionCommand) command).getPosY() * value));
        else if (command instanceof ICompoundCommand) {
            DriverCommand newCommand;

            Iterator<DriverCommand> iterator = ((ICompoundCommand) command).iterator();

            while (iterator.hasNext()) {
                DriverCommand command1 = iterator.next();
                newCommand = performTransformation(command1);
                compoundCommand.addComand(newCommand);
            }

        }
        return compoundCommand;
    }

    public float getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
