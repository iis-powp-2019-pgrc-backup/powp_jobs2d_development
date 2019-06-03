package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverDecoratorFeature;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.SelectDriverDecoratorMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.SelectDriverMenuOptionListener;
import edu.kis.powp.observer.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverFeature {

	private static DriverManager driverManager = new DriverManager();
	private static Application app;
	private static Subscriber subscriber = () -> {
		updateDriverInfo();
		checkDecorator();
	};



	public static DriverManager getDriverManager() {
		return driverManager;
	}

	/**
	 * Setup jobs2d drivers Plugin and add to application.
	 *
	 * @param application Application context.
	 */
	public static void setupDriverPlugin(Application application) {
		app = application;
		app.addComponentMenu(DriverFeature.class, "Drivers");
		driverManager.addSubscriber(subscriber);
	}

	public static void setupDriverDecoratorsPlugin(Application application){
		app = application;
		app.addComponentMenu(DriverDecoratorFeature.class, "Drivers Decorators");
		if(!driverManager.getSubscribers().contains(subscriber))
		    driverManager.addSubscriber(subscriber);
	}

	/**
	 * Add driver to context, create button in driver menu.
	 *
	 * @param name   Button name.
	 * @param driver Job2dDriver object.
	 */
	public static void addDriver(String name, Job2dDriver driver) {
		SelectDriverMenuOptionListener listener = new SelectDriverMenuOptionListener(driver, driverManager);
		app.addComponentMenuElement(DriverFeature.class, name, listener);
	}

	public static void addDriverDecorator(String name, Class decorator){
        SelectDriverDecoratorMenuOptionListener listener = new SelectDriverDecoratorMenuOptionListener(decorator);
        app.addComponentMenuElement(DriverDecoratorFeature.class, name,listener );

	}

	/**
	 * Update driver info.
	 */
	public static void updateDriverInfo() {
		app.updateInfo(driverManager.getCurrentDriver().toString());
	}

	public static void checkDecorator(){
        Job2dDriver decoratedDriver = driverManager.getCurrentDriver();

        for (Class decoratorClass:
             DriverDecoratorFeature.getDecoratorMap()) {
            try {
                decoratedDriver = (Job2dDriver) decoratorClass.getConstructor(Job2dDriver.class).newInstance(decoratedDriver);

            }
            catch (Exception e){
                DriverDecoratorFeature.getDecoratorMap().remove(decoratorClass);
            }
        }

        driverManager.setCurrentDriver(decoratedDriver);

	}
}
