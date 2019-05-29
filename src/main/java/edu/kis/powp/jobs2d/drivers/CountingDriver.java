package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;

import java.util.logging.Logger;

public class CountingDriver extends LineDriverAdapter
{
    Logger logger = Logger.getLogger("global");

    public CountingDriver(DrawPanelController drawController, ILine line, String name) {
        super(drawController, line, name);
    }

    public void setPosition(int x, int y) {
        this.logger.info("Begin counting");
    }

    public void operateTo(int x, int y) {

        this.logger.info("Very expensive positioning...");
    }

    public String toString() {
        return "Logger driver";
    }
}
