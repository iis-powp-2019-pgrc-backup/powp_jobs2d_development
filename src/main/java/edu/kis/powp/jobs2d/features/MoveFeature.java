package edu.kis.powp.jobs2d.features;

import java.util.logging.Logger;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.panel.Drag;


public class MoveFeature {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private static Application app;
	public static int x=0;
	public static int y=0; 

	/**
	 * Setup jobs2d drivers Plugin and add to application.
	 * 
	 * @param application Application context.
	 */
	public static void setupMovePlugin(Application application) {
		app = application;
		app.addComponentMenu(MoveFeature.class, "Move");
	}


	public static  void setX() {
		//DrawerFeature.getDrawerController().clearPanel();
		MoveFeature.x+=20;
		System.out.println("x: " + MoveFeature.x);
		logger.info("x:" + MoveFeature.x);
		
	}


	public static void setY() {
		//DrawerFeature.getDrawerController().clearPanel();
		MoveFeature.y+=20;
		System.out.println("y: " + MoveFeature.y);
		logger.info("y: " + MoveFeature.y);
	}
	
	public static  void setXX() {
		//DrawerFeature.getDrawerController().clearPanel();
		MoveFeature.x-=20;
		System.out.println("x: " + MoveFeature.x);
		logger.info("x: " + MoveFeature.x);
	}


	public static void setYY() {
		//DrawerFeature.getDrawerController().clearPanel();
		MoveFeature.y-=20;
		System.out.println("y: " + MoveFeature.y);
		logger.info("y: " + MoveFeature.y);
	}

	public static void mouseevent(int z , int r) {
		MoveFeature.y=r-232;
		MoveFeature.x=z-270;
        logger.info("x: " + MoveFeature.x + " y: " + MoveFeature.y);
	}

	public static void reset() {
		MoveFeature.y=0;
		MoveFeature.x=0;
		logger.info("x: " + MoveFeature.x + " y: " + MoveFeature.y);
	}

    public static void engage1()
    {
        new Drag();
    }

}
