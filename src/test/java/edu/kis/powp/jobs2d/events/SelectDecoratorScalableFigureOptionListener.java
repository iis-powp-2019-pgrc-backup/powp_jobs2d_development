package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Transformators.ScalableActionListener;
import edu.kis.powp.jobs2d.Transformators.Scaler;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.util.List;

public class SelectDecoratorScalableFigureOptionListener implements ScalableActionListener {

    private double factor;
    private ScalableActionListener listener;
    private Scaler scaler = new Scaler();

    public SelectDecoratorScalableFigureOptionListener(ScalableActionListener listener, double factor){
        this.listener = listener;
        this.factor = factor;
    }

    @Override
    public List<DriverCommand> getCommands() {
        return scaler.scale(listener,factor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(scaler.scale(listener,factor), "ScalableCommand");
    }
}
