package edu.kis.powp.jobs2d.drivers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDriverDecoratorMenuOptionListener  implements ActionListener {

    private DriverDecoratorManager driverDecoratorManager;
    private DriverDecoratorApplicator driverDecoratorApplicator;

    public SelectDriverDecoratorMenuOptionListener(DriverDecoratorManager driverDecoratorManager, DriverDecoratorApplicator driverDecoratorApplicator) {
        this.driverDecoratorManager = driverDecoratorManager;
        this.driverDecoratorApplicator = driverDecoratorApplicator;
    }

    @Override public void actionPerformed(ActionEvent e) {
        driverDecoratorManager.changeStateOfDecorator(driverDecoratorApplicator);
        System.out.println(driverDecoratorApplicator.getDecoratorClass().getSimpleName() + ": " + driverDecoratorApplicator.isStateToDecorate());
    }
}
