package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.features.TracedCommandsFeature;

public class ClearTracedCommandOptionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TracedCommandsFeature.clearTracedCommands();
	}
}
