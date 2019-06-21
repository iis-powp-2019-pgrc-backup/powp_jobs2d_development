package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.observer.Publisher;

import java.util.ArrayList;

public class DriverDecoratorManager extends Publisher {

    private ArrayList<DriverDecoratorApplicator> listOfDecorators = new ArrayList<>();

    public void addDriverDecorator(DriverDecoratorApplicator driverDecoratorApplicator) {
        listOfDecorators.add(driverDecoratorApplicator);
    }

    public void changeStateOfDecorator(DriverDecoratorApplicator driverDecoratorApplicator) {
        if(listOfDecorators.contains(driverDecoratorApplicator)){
            driverDecoratorApplicator.changeStateToDecorate();
            updateDecorationOfDriver();
        }
    }

    public Job2dDriver applicateDecorationOnDriver(Job2dDriver job2dDriver){
        for (DriverDecoratorApplicator driverDecoratorApplicator :
                listOfDecorators) {
            job2dDriver = driverDecoratorApplicator.applicateDecoration(job2dDriver);
        }
        return job2dDriver;
    }

    private synchronized void updateDecorationOfDriver() {
        notifyObservers();
    }

}
