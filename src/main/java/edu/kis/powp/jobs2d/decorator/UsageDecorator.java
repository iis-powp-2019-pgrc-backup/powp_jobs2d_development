package edu.kis.powp.jobs2d.decorator;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.logger.UsageLogger;

public class UsageDecorator implements Job2dDriver {

	protected Job2dDriver driver;
	
	public UsageDecorator( Job2dDriver _driver ) {
		this.driver = _driver;
	}
	
	@Override
	public void setPosition(int x, int y) {
		UsageLogger.setPosition(x, y);
		
		this.driver.setPosition(x, y);
	}

	@Override
	public void operateTo(int x, int y) {
		UsageLogger.operateTo(x, y);
		
		this.driver.operateTo(x, y);
		
		System.out.println( UsageLogger.showInfo() );
	}

}
