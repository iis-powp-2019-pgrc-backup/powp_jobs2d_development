package edu.kis.powp.jobs2d.logger;

public class UsageLogger {

	public static int totalUsage = 0;
	public static int totalConsumption = 0;
	public static int oldX = 0;
	public static int oldY = 0;
	
	public static void increaseConsumption( int x, int y ) {
		totalConsumption += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		totalUsage += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		
		oldX = x;
		oldY = y;
	}
	
	public static void setPosition( int x, int y ) {
		totalUsage += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		
		oldX = x;
		oldY = y;
	}
	
	public static String showInfo() {
		return "Total consumption: " + Integer.toString( totalConsumption ) + "\n" +
				"Total usage: " + Integer.toString( totalUsage ) + "\n" ;
	}
	
}
