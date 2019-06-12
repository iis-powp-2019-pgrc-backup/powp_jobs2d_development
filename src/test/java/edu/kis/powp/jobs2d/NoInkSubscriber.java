package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.gui.InkFillerWindow;
import edu.kis.powp.jobs2d.drivers.CountingDriver;
import edu.kis.powp.jobs2d.features.Publisher;

public class NoInkSubscriber implements edu.kis.powp.jobs2d.features.Subscriber {

    Job2dDriver countingDriver;

    public NoInkSubscriber(Job2dDriver countingDriver){
        this.countingDriver = countingDriver;
    }

    @Override
    public void update(String info) {
        InkFillerWindow inkFillerWindow = new InkFillerWindow(countingDriver);

        System.out.println(info);
    }
}
