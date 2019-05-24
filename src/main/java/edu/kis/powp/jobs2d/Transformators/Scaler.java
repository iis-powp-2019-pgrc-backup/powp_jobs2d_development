package edu.kis.powp.jobs2d.Transformators;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.CommandVisitor;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scaler implements CommandVisitor, Transformator {

    private double factor;

    public Scaler(double factor)
    {
        this.factor = factor;
    }

    @Override
    public void visit(SetPositionCommand command) {
        transform(command);
    }

    @Override
    public void visit(OperateToCommand command) {
        transform(command);
    }

    @Override
    public void visit(ICompoundCommand command) {
        command.iterator().forEachRemaining(s -> s.accept(this));
    }

    @Override
    public void transform(SetPositionCommand command) {
        new SetPositionCommand((int)(command.getPosX()*factor),(int)(command.getPosY()*factor)).execute(DriverFeature.getDriverManager().getCurrentDriver());
    }

    @Override
    public void transform(OperateToCommand command) {
        new OperateToCommand((int)(command.getPosX()*factor),(int)(command.getPosY()*factor)).execute(DriverFeature.getDriverManager().getCurrentDriver());
    }
}
