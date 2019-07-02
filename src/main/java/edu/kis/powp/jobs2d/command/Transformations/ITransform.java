package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.CompoundCommand;

public interface ITransform {

    public CompoundCommand performTransformation(CompoundCommand compoundCommand);
}
