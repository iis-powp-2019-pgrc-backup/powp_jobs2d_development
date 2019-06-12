package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.Publisher;

import java.util.logging.Logger;

public class CountingDriver implements Job2dDriver
{
    Logger logger = Logger.getLogger("global");
    private int startX = 0, startY = 0;
    private ILine line;
    private float inkAmount = 0f;
    private DrawPanelController drawController;

    public static String PublisherName = "Ink";
    Publisher pub = Publisher.getPublisher(PublisherName);


    public CountingDriver(DrawPanelController drawController, ILine line, float inkAmount) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.inkAmount = inkAmount;

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

        float ink = (float)Math.sqrt(Math.pow(line.getStartCoordinateX() - line.getEndCoordinateX(), 2.0)
                                    + Math.pow(line.getStartCoordinateY() - line.getEndCoordinateY(), 2.0));

        inkAmount -= ink;
        if(inkAmount < 0)
        {
            this.logger.info("not enough ink to draw line");
            if(pub != null)
            {
                pub.notifyObservers("not enough ink to draw line");
            }
        }
        else
        {
            drawController.drawLine(line);
            this.logger.info("wase " + String.format ("%.3f", ink) + " ml of ink");
        }
    }

    @Override
    public String toString() {
        return "Counting driver";
    }
}
