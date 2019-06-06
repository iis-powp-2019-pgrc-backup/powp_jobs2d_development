package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.manager.CommandVisitor;

/**
 * Implementation of Job2dDriverCommand for operateTo command functionality.
 */
public class OperateToCommand implements DriverCommand {

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void accept(CommandVisitor visitor)
	{
		visitor.visit(this);
	}

	private int posX, posY;

	public OperateToCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void execute(Job2dDriver driver) {
		driver.operateTo(posX, posY);
	}

}
