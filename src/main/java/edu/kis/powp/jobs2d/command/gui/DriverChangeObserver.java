package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.movment.MoveDriverAdapter;
import edu.kis.powp.observer.Subscriber;


import static edu.kis.powp.jobs2d.features.DriverFeature.getDriverManager;


public class DriverChangeObserver  {
    private static  Subscriber subscriber = () -> update();
    private static boolean OnOff;

    public DriverChangeObserver() {
        super();
        OnOff = true;
        getDriverManager().addSubscriber(subscriber);
    }

    public String toString() {
        return "Current driver change observer for application";
    }

    public static void update() {
        if(OnOff)
            getDriverManager().
                    setCurrentDriver(new MoveDriverAdapter(getDriverManager().
                            getCurrentDriver(), "Line"));
    }

    public static void clearSubscriber() { OnOff = false; }

    public static void setSubscriber() { OnOff = true; }

}