

package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.*;

import java.util.Iterator;

public class VerticalMirrorTransformation implements ITransform {

    public VerticalMirrorTransformation() {
    }

    @Override
    public DriverCommand performTransformation(DriverCommand command) {
        if (command instanceof OperateToCommand)
            return new OperateToCommand(
                    (((OperateToCommand) command).getPosX() * -1),
                    (((OperateToCommand) command).getPosY()));
        else if (command instanceof SetPositionCommand)
            return new SetPositionCommand(
                    (((SetPositionCommand) command).getPosX() * -1),
                    (((SetPositionCommand) command).getPosY()));
        else if (command instanceof ICompoundCommand) {
            ICompoundCommand compoundCommand = new CompoundCommand();
            Iterator <DriverCommand> iterator = ((ICompoundCommand) command).iterator();
            while (iterator.hasNext()) {
                DriverCommand command1 = iterator.next();
                DriverCommand newCommand1 = performTransformation(command1);
                ((CompoundCommand) compoundCommand).addComand(newCommand1);
            }
            return compoundCommand;
        }
        return null;
    }
}
