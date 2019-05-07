package edu.kis.powp.jobs2d.drivers.gui;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

public class DriverChangeObserver implements Subscriber {

    private Application app;

    public DriverChangeObserver(Application app) {
        super();
        this.app = app;
    }

    public String toString() {
        return "Current driver change observer for application";
    }

    @Override
    public void update() {
        app.updateInfo(DriverFeature.getDriverManager().getCurrentDriver().toString());
    }
}
