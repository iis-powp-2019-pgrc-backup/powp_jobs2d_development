package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;

import javax.sound.sampled.Line;
import java.util.logging.Logger;

public class CountingDriver implements Job2dDriver
{
    Logger logger = Logger.getLogger("global");
    private int startX = 0, startY = 0;
    private ILine line;

    private DrawPanelController drawController;

    public CountingDriver(DrawPanelController drawController, ILine line) {
        super();
        this.drawController = drawController;
        this.line = line;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        this.setPosition(x, y);
        line.setEndCoordinates(x, y);

        drawController.drawLine(line);

        double ink = Math.sqrt(Math.pow(line.getStartCoordinateX() - line.getEndCoordinateX(), 2.0)
                             + Math.pow(line.getStartCoordinateY() - line.getEndCoordinateY(), 2.0));

        this.logger.info("wase " + String.format ("%.3f", ink) + " ml of ink");
    }

    @Override
    public String toString() {
        return "Counting driver";
    }
}
