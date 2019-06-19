package edu.kis.powp.jobs2d.logger;

import edu.kis.powp.observer.Publisher;

public class UsageLogger {

	protected float totalUsage = 0;
	protected float totalConsumption = 0;
	
	protected int oldX = 0;
	protected int oldY = 0;
	protected boolean empty = false;

	private Publisher changePublisher = new Publisher();

	public void increaseInkConsumption(int x, int y ) {
		totalConsumption += calculateUsage(x,y);
		
		increaseHeadUsage( x, y );
		changePublisher.notifyObservers();
	}
	
	public void increaseHeadUsage(int x, int y ) {
		totalUsage += calculateUsage(x,y);
		
		oldX = x;
		oldY = y;
		changePublisher.notifyObservers();
	}

	public Publisher getPublisher(){
		return changePublisher;
	}
	
	public float getTotalUsage() {
	    return this.totalUsage;
	}

	public void setEmpty( boolean state) {
		this.empty = state;
	}
	
	public String toString() {
		return ( empty ) ? "Tusz wyczerpany" : "Ink consumption: " + String.format("%.2f", totalConsumption/115) + " l\n" +
												"Head usage: " + String.format("%.2f", totalUsage/115) + "cm\n";
	}

	public float calculateUsage( int x, int y ){
        return (float) Math.sqrt( (oldX - x)*(oldX - x) + (oldY - y)*(oldY - y) );
    }
	
}
