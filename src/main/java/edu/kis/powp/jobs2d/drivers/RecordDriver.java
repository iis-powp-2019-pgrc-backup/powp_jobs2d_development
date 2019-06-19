package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.RecorderFeature;
import edu.kis.powp.observer.Publisher;

public class RecordDriver implements Job2dDriver {

    private Job2dDriver nextDriver;

    public RecordDriver(Job2dDriver nextDriver) {
        this.nextDriver = nextDriver;
    }

    @Override
    public void setPosition(int x, int y) {
        if(RecorderFeature.isRecordInProgress()) RecorderFeature.record(new SetPositionCommand(x, y));
        if(nextDriver != null) nextDriver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        if(RecorderFeature.isRecordInProgress()) RecorderFeature.record(new OperateToCommand(x, y));
        if(nextDriver != null) nextDriver.operateTo(x, y);
    }

    @Override
    public String toString() {
        return nextDriver.toString() + (RecorderFeature.isRecordInProgress() ? " (recording)" : "");
    }
}
