package edu.kis.powp.jobs2d.Transformators;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.awt.event.ActionListener;
import java.util.List;

/**
 * Class implementing this interface can be scalable (i.e commands are explicit and can be modified)
 */
public interface ScalableActionListener extends ActionListener {
    List<DriverCommand> getCommands();
}
