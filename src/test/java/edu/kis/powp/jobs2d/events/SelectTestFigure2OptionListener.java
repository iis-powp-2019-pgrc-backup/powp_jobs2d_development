package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.resources.ResourceClassSingleton;

public class SelectTestFigure2OptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigure2OptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ResourceClassSingleton.getInstance().changeStatusIsWindowOpenedUp();
		FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
