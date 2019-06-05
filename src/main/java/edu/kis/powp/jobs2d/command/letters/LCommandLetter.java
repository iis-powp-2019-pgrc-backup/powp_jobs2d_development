package edu.kis.powp.jobs2d.command.letters;

import edu.kis.powp.jobs2d.Job2dDriver;

public class LCommandLetter implements ComplexCommand {

    private Job2dDriver job2dDriver;

    public LCommandLetter(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    @Override public void execute() {
        job2dDriver.setPosition(0, 0);
        job2dDriver.operateTo(-120, 0);
        job2dDriver.operateTo(-120, -120);
    }

}
