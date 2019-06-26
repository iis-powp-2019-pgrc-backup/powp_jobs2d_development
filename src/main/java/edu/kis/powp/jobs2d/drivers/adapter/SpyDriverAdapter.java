package edu.kis.powp.jobs2d.drivers.adapter;

import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class SpyDriverAdapter implements Job2dDriver {

	List<DriverCommand> tracedCommandsList;
	
	public SpyDriverAdapter(List<DriverCommand> commands) {
		this.tracedCommandsList = commands;
	}

	@Override
	public void setPosition(int x, int y) {
		tracedCommandsList.add(new SetPositionCommand(x, y));
	}

	@Override
	public void operateTo(int x, int y) {
		tracedCommandsList.add(new OperateToCommand(x, y));
	}

	@Override
	public String toString() {
		return "2d device simulator - spy";
	}
}
