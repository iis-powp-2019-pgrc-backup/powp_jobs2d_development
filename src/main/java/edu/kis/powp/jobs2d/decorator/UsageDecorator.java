package edu.kis.powp.jobs2d.decorator;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.logger.UsageLogger;

public class UsageDecorator implements Job2dDriver {

	protected Job2dDriver driver;
	private UsageLogger logger;
	
	public UsageDecorator( Job2dDriver _driver, UsageLogger _logger ) {
		this.driver = _driver;
		this.logger = _logger;
	}
	
	@Override
	public void setPosition(int x, int y) {
		this.logger.setPosition(x, y);
		
		this.driver.setPosition(x, y);
	}

	@Override
	public void operateTo(int x, int y) {
		this.logger.operateTo(x, y);
		
		this.driver.operateTo(x, y);
		
		System.out.println( logger.showInfo() );
	}

}
