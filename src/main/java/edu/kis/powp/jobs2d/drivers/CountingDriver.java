package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.gui.InkFillerWindow;
import edu.kis.powp.jobs2d.features.Publisher;

import java.util.logging.Logger;

public class CountingDriver implements Job2dDriver
{
    Logger logger = Logger.getLogger("global");
    private int startX = 0, startY = 0;
    private ILine line;
    private float inkAmount;
    private DrawPanelController drawController;
    private boolean isEmpty = false;

    public static String PublisherName = "Ink";
    Publisher pub = null;


    public CountingDriver(DrawPanelController drawController, ILine line, float inkAmount) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.inkAmount = inkAmount;
        pub = Publisher.getPublisher(PublisherName);
    }

    public void addInk(float additionalInk)
    {
        inkAmount += additionalInk;
        if(inkAmount > 0)
            isEmpty = false;
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

        while(true) {
            if (inkAmount < ink && isEmpty == false) {
                isEmpty = true;

                this.logger.info("not enough ink to draw line");
                if (pub != null) {
                    pub.notifyObservers("not enough ink to draw line");
                }
            }
            if (inkAmount >= ink) {
                inkAmount -= ink;

                drawController.drawLine(line);
                this.logger.info("use " + String.format("%.3f", ink) + " ml of ink");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Counting driver";
    }
}
