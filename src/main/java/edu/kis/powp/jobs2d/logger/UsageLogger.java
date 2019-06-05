package edu.kis.powp.jobs2d.logger;

public class UsageLogger {

	public static float totalUsage = 0;
	public static float totalConsumption = 0;
	public static int oldX = 0;
	public static int oldY = 0;
	
	public static void increaseConsumption( int x, int y ) {
		totalConsumption += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		totalConsumption = totalConsumption / 115;
		
		totalUsage += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		totalUsage = totalUsage/10;
		
		oldX = x;
		oldY = y;
	}
	
	public static void setPosition( int x, int y ) {
		totalUsage += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		totalUsage = totalUsage/10;
		
		oldX = x;
		oldY = y;
	}
	
	public static String showInfo() {
		return "Ink consumption: " + Float.toString( totalConsumption ) + " l\n" +
				"Head usage: " + Float.toString( totalUsage ) + "cm\n" ;
	}
	
}
