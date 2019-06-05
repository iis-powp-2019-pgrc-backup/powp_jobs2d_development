package edu.kis.powp.jobs2d.logger;

public class UsageLogger {

	protected float totalUsage = 0;
	protected float totalConsumption = 0;
	
	protected int oldX = 0;
	protected int oldY = 0;
	
	public void operateTo( int x, int y ) {
		totalConsumption += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		
		setPosition( x, y );
	}
	
	public void setPosition( int x, int y ) {
		totalUsage += Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
		
		oldX = x;
		oldY = y;
	}
	
	public String showInfo() {
		return "Ink consumption: " + Float.toString( totalConsumption/115 ) + " l\n" +
				"Head usage: " + Float.toString( totalUsage/30 ) + "cm\n";
	}
	
}
