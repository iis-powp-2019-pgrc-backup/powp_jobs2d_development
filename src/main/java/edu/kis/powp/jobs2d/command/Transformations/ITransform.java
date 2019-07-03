package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;

public interface ITransform {

    public DriverCommand performTransformation(DriverCommand command);
}
