package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindow;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindowCommandChangeObserver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.events.SelectLoadSecretCommandOptionListener;
import edu.kis.powp.jobs2d.events.SelectLoadTriangleListener;
import edu.kis.powp.jobs2d.events.SelectRunCurrentCommandOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestCustomFigureOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigure2OptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import edu.kis.powp.jobs2d.features.MoveFeature;
import edu.kis.powp.jobs2d.movment.Rotate;
import edu.kis.powp.jobs2d.movment.MovmentPoint;
import edu.kis.powp.jobs2d.movment.MoveDriverAdapter;
import edu.kis.powp.jobs2d.movment.MovmentManager;
import edu.kis.powp.jobs2d.panel.JPanelMouseControl;

public class TestJobs2dApp {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager());
		SelectTestFigure2OptionListener selectTestFigure2OptionListener = new SelectTestFigure2OptionListener(
				DriverFeature.getDriverManager());

		application.addTest("Figure Joe 1", selectTestFigureOptionListener);
		application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
	}

	/**
	 * Setup test using driver commands in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupCommandTests(Application application) {
		application.addTest("Load secret command", new SelectLoadSecretCommandOptionListener());
		application.addTest("Load Triangle", new SelectLoadTriangleListener());
		application.addTest("Load Custom figure", new SelectTestCustomFigureOptionListener());
		application.addTest("Run command", new SelectRunCurrentCommandOptionListener(DriverFeature.getDriverManager()));

	}

	/**
	 * Setup driver manager, and set default Job2dDriver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger driver", loggerDriver);

		DrawPanelController drawerController = DrawerFeature.getDrawerController();
		Job2dDriver driver = new LineDriverAdapter(drawerController, LineFactory.getBasicLine(), "basic");
		DriverFeature.addDriver("Line Simulator", driver);
		DriverFeature.getDriverManager().setCurrentDriver(driver);

		MoveDriverAdapter moveDriverAdapter;
		moveDriverAdapter = new MoveDriverAdapter(driver, "transform");
		moveDriverAdapter.addTransformation(new MovmentPoint(MoveFeature.getMovmentManager()));
		moveDriverAdapter.addTransformation(new Rotate(MoveFeature.getMovmentManager()));
		driver = moveDriverAdapter;
		DriverFeature.addDriver("Move Simulator", driver);
		DriverFeature.updateDriverInfo();


	}

	private static void setupWindows(Application application) {

		CommandManagerWindow commandManager = new CommandManagerWindow(CommandsFeature.getDriverCommandManager());
		application.addWindowComponent("Command Manager", commandManager);

		CommandManagerWindowCommandChangeObserver windowObserver = new CommandManagerWindowCommandChangeObserver(
				commandManager);
		CommandsFeature.getDriverCommandManager().getChangePublisher().addSubscriber(windowObserver);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {

		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	private static void setupMove(Application application) {
		application.addComponentMenu(MovmentManager.class, "Move");
		application.addComponentMenuElement(MovmentManager.class, "Up", (ActionEvent e) -> MovmentManager.setYY());
		application.addComponentMenuElement(MovmentManager.class, "Down", (ActionEvent e) -> MovmentManager.setY());
		application.addComponentMenuElement(MovmentManager.class, "Right", (ActionEvent e) -> MovmentManager.setX());
		application.addComponentMenuElement(MovmentManager.class, "Left", (ActionEvent e) -> MovmentManager.setXX());
		application.addComponentMenuElement(MovmentManager.class, "Reset", (ActionEvent e) -> MovmentManager.reset());

	}
	private static void setupRotate(Application application) {
		application.addComponentMenu(MovmentManager.class, "Rotate");
		application.addComponentMenuElement(MovmentManager.class, "RotationUp", (ActionEvent e) -> MovmentManager.RotationUp());
		application.addComponentMenuElement(MovmentManager.class, "RotationDown", (ActionEvent e) -> MovmentManager.RotationDown());
		application.addComponentMenuElement(MovmentManager.class, "RotationReset", (ActionEvent e) -> MovmentManager.RotationReset());

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("Jobs 2D");
				DrawerFeature.setupDrawerPlugin(app);
				CommandsFeature.setupCommandManager();
				MoveFeature.setupTransformManager();
				setupMove(app);
				setupRotate(app);
				DriverFeature.setupDriverPlugin(app);

				setupDrivers(app);
				setupPresetTests(app);
				setupCommandTests(app);
				setupLogger(app);
				setupWindows(app);

				JPanelMouseControl.engage(app.getFreePanel(), DriverFeature.getDriverManager());

				app.setVisibility(true);
			}
		});
	}

}
