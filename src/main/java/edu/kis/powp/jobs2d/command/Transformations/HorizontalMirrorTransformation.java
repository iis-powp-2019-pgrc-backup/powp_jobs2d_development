package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class HorizontalMirrorTransformation implements ITransform {

    public HorizontalMirrorTransformation() {
    }

    @Override
    public CompoundCommand performTransformation(CompoundCommand compoundCommand) {
        CompoundCommand newCompoundCommand = new CompoundCommand();
        DriverCommand newCommand = null;
        while(compoundCommand.iterator().hasNext()){
            DriverCommand command = compoundCommand.iterator().next();
            if (command instanceof OperateToCommand)
                newCommand = new OperateToCommand(((OperateToCommand) command).getPosX(), ((OperateToCommand) command).getPosY() * -1);
            else if (command instanceof SetPositionCommand)
                newCommand = new SetPositionCommand(((SetPositionCommand) command).getPosX(), ((SetPositionCommand) command).getPosY() * -1);
            newCompoundCommand.addComand(newCommand);
        }
        return newCompoundCommand;
    }

}
