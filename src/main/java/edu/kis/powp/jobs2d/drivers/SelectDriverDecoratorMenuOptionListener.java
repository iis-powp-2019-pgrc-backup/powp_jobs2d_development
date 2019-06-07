package edu.kis.powp.jobs2d.drivers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class SelectDriverDecoratorMenuOptionListener  implements ActionListener {

    private DriverManager driverManager;
    private DriverDecorator driverDecorator;

    public SelectDriverDecoratorMenuOptionListener(DriverManager driverManager, DriverDecorator driverDecorator) {
        this.driverManager = driverManager;
        this.driverDecorator = driverDecorator;
    }

    @Override public void actionPerformed(ActionEvent e) {
        if(driverDecorator.isStateToDecorate()) driverDecorator.setStateToDecorate(false);
        else driverDecorator.setStateToDecorate(true);

        System.out.println(driverDecorator.getDecoratorClass().getSimpleName()+": " + driverDecorator.isStateToDecorate());

        driverManager.notifyObservers();
    }
}
