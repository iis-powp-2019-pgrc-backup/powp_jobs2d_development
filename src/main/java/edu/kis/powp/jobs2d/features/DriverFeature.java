package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverDecoratorApplicator;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.SelectDriverDecoratorMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.SelectDriverMenuOptionListener;
import edu.kis.powp.observer.Subscriber;

import java.util.ArrayList;

public class DriverFeature {

	private static DriverManager driverManager = new DriverManager();
	private static Application app;
	private static Subscriber decoratorSubscriber = () -> checkDecorator();
    private static Subscriber driverSubscriber = () -> 	updateDriverInfo();

	private static ArrayList<DriverDecoratorApplicator> listOfDecorators = new ArrayList<>();

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
		driverManager.addSubscriber(driverSubscriber);
	}

	public static void setupDriverDecoratorsPlugin(Application application){
		app = application;
		app.addComponentMenu(DriverDecoratorApplicator.class, "Drivers Decorators");
		driverManager.addSubscriber(decoratorSubscriber);
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
		DriverDecoratorApplicator driverDecoratorApplicator = new DriverDecoratorApplicator(decorator, false);
		listOfDecorators.add(driverDecoratorApplicator);
		SelectDriverDecoratorMenuOptionListener listener = new SelectDriverDecoratorMenuOptionListener(driverManager,
				driverDecoratorApplicator);
		app.addComponentMenuElement(DriverDecoratorApplicator.class, name, listener);
	}

	/**
	 * Update driver info.
	 */
	public static void updateDriverInfo() {
		app.updateInfo(driverManager.getCurrentDriver().toString());
	}

	public static void checkDecorator(){
		Job2dDriver currentDriver = driverManager.getCurrentDriver();

		for (DriverDecoratorApplicator driverDecoratorApplicator :
				listOfDecorators) {
			currentDriver = driverDecoratorApplicator.applicateDecoration(currentDriver);
		}

	}
}
