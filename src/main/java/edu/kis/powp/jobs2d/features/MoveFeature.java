package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;


public class MoveFeature {

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
		MoveFeature.x+=20;
		System.out.println("x: " + MoveFeature.x);
	}


	public static void setY() {
		MoveFeature.y+=20;
		System.out.println("y: " + MoveFeature.y);
	}
	
	public static  void setXX() {
		MoveFeature.x-=20;
		System.out.println("x: " + MoveFeature.x);
	}


	public static void setYY() {
		MoveFeature.y-=20;
		System.out.println("y: " + MoveFeature.y);
	}


	public static void reset() {
		MoveFeature.y=0;
		MoveFeature.x=0;
		System.out.println("x: " + MoveFeature.x + " " + "y: " + MoveFeature.y);
	}
	

}
