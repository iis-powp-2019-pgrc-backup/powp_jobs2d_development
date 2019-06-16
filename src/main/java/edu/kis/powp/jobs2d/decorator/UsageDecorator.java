package edu.kis.powp.jobs2d.decorator;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.logger.UsageLogger;

public class UsageDecorator implements Job2dDriver {

	protected Job2dDriver driver;
	private UsageLogger logger;
	
	private float inkLimit;
	
	public UsageDecorator( Job2dDriver _driver, UsageLogger _logger ) {
		this.driver = _driver;
		this.logger = _logger;
		this.inkLimit = 9000;
	}
	
	@Override
	public void setPosition(int x, int y) {
		this.logger.increaseHeadUsage(x, y);
		
		this.driver.setPosition(x, y);
	}

	@Override
	public void operateTo(int x, int y) {
		if( this.logger.getTotalUsage() < inkLimit ) {
			this.logger.increaseInkConsumption(x, y);
			
			this.driver.operateTo(x, y);
			
			System.out.println( logger.showInfo() );
			DriverFeature.updateDriverInfo();
		}else {
			System.out.println( "Tusz wyczerpany!");
		}
	}
	
	@Override
	public String toString() {
		return logger.showInfo();
	}

}
