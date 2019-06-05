package edu.kis.powp.jobs2d.command.letters;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FCommandLetter implements ComplexCommand {

    private Job2dDriver job2dDriver;

    public FCommandLetter(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    @Override
    public void execute() {
        job2dDriver.setPosition(0, 0);
        job2dDriver.operateTo(0, -100);
        job2dDriver.operateTo(100, -100);
        job2dDriver.operateTo(0, -100);
        job2dDriver.operateTo(0, -150);
        job2dDriver.operateTo(100, -150);
    }
}
