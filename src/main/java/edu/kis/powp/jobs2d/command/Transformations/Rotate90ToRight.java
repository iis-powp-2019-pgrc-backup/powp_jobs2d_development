
package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.*;

import java.util.Iterator;

public class Rotate90ToRight implements ITransform{


    public Rotate90ToRight() {
    }

    @Override
    public DriverCommand performTransformation(DriverCommand command) {
        if (command instanceof OperateToCommand)
            return new OperateToCommand(
                    (((OperateToCommand) command).getPosY() * -1),
                    (((OperateToCommand) command).getPosX()));
        else if (command instanceof SetPositionCommand)
            return new SetPositionCommand(
                    (((SetPositionCommand) command).getPosY() * -1),
                    (((SetPositionCommand) command).getPosX()));
        else if (command instanceof ICompoundCommand) {
            CompoundCommand compoundCommand = new CompoundCommand();
            Iterator<DriverCommand> iterator = ((ICompoundCommand) command).iterator();
            while (iterator.hasNext()) {
                DriverCommand command1 = iterator.next();
                DriverCommand newCommand1 = performTransformation(command1);
                compoundCommand.addComand(newCommand1);
            }
            return compoundCommand;
        }
        return null;
    }
}
