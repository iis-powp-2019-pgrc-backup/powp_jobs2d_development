package edu.kis.powp.jobs2d.drivers.gui;

import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

public class DriverChangeObserver implements Subscriber {

    public DriverChangeObserver() {
        super();
    }

    public String toString() {
        return "Current driver change observer for application";
    }

    @Override
    public void update() {
        DriverFeature.updateDriverInfo();
    }
}
