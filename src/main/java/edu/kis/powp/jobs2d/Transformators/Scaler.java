package edu.kis.powp.jobs2d.Transformators;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scaler implements Transformator {

    private double factor;

    public Scaler(double factor)
    {
        this.factor = factor;
    }

    @Override
    public void transform() {

        DriverCommand command = CommandsFeature.getDriverCommandManager().getCurrentCommand();
        if(command instanceof ICompoundCommand)
        {
            Iterator<DriverCommand> iterator = ((ICompoundCommand) command).iterator();
            iterator.forEachRemaining(s -> {
                if(s instanceof SetPositionCommand)
                    new SetPositionCommand((int)(((SetPositionCommand) s).getPosX()*factor),(int)(((SetPositionCommand) s).getPosY()*factor)).execute(DriverFeature.getDriverManager().getCurrentDriver());
                else if(s instanceof OperateToCommand)
                    new OperateToCommand((int)(((OperateToCommand) s).getPosX()*factor),(int)(((OperateToCommand) s).getPosY()*factor)).execute(DriverFeature.getDriverManager().getCurrentDriver());
            });
        }

    }
}
