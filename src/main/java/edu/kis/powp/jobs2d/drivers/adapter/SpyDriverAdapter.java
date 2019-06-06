package edu.kis.powp.jobs2d.drivers.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class SpyDriverAdapter implements Job2dDriver {

	private List<DriverCommand> tracedCommandsList;
	
	public List<DriverCommand> getTracedCommandsList() {
		return tracedCommandsList;
	}

	public SpyDriverAdapter() {
		this.tracedCommandsList = new ArrayList<DriverCommand>();
	}

	@Override
	public void setPosition(int x, int y) {
		tracedCommandsList.add(new SetPositionCommand(x, y));
	}

	@Override
	public void operateTo(int x, int y) {
		tracedCommandsList.add(new OperateToCommand(x, y));
	}
	
	public void clearTracedCommandList() {
		this.tracedCommandsList.clear();
	}
}
