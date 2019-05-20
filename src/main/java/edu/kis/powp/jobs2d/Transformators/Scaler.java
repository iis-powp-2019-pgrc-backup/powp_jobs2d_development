package edu.kis.powp.jobs2d.Transformators;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class Scaler {

    public List<DriverCommand> scale(ScalableActionListener listener, double factor)
    {
        List<DriverCommand> newCommands = new ArrayList<>();
        try {
            for (DriverCommand command : listener.getCommands()) {
                if(command instanceof OperateToCommand)
                    newCommands.add(new OperateToCommand((int)(((OperateToCommand) command).getPosX()*factor),(int)(((OperateToCommand) command).getPosY()*factor)));
                else
                    newCommands.add(new SetPositionCommand((int)(((SetPositionCommand) command).getPosX()*factor),(int)(((SetPositionCommand) command).getPosY()*factor)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return newCommands;
    }
}
