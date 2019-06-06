package edu.kis.powp.jobs2d.command.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.manager.CommandParser;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 9204679248304669948L;
	CommandParser commandParser = new CommandParser();
	private ICommandController controller;
	private JTextArea currentCommandField;
	private String observerListString;
	private JTextArea observerListField;
	private JTextField inputCommand;

	public CommandManagerWindow(CommandController commandController) {
		this.controller = commandController;
		this.setTitle("Command Manager");
		this.setSize(400, 400);
	}

	public void CommandManagerWindowContent() {

		Container content = this.getContentPane();
		content.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		observerListField = new JTextArea("");
		observerListField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(observerListField, c);
		updateObserverListField();

		inputCommand = new JTextField("");
		inputCommand.setEditable(true);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(inputCommand, c);


		currentCommandField = new JTextArea("");
		currentCommandField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(currentCommandField, c);
		updateCurrentCommandField();

		JButton btnRunCommand = new JButton("Run Command");
		btnRunCommand.addActionListener((ActionEvent e) -> this.runCommand());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnRunCommand, c);

		JButton btnClearCommand = new JButton("Clear command");
		btnClearCommand.addActionListener((ActionEvent e) -> this.clearCommand());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnClearCommand, c);

		JButton btnClearObservers = new JButton("Observers ON/OFF");
		btnClearObservers.addActionListener((ActionEvent e) -> this.setObserversActiveOrInactive());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnClearObservers, c);
	}

	private void clearCommand() {
		commandParser.clearCommands();
		controller.clearCurrentCommand();
		updateCurrentCommandField();
	}

	public void updateCurrentCommandField() {
		currentCommandField.setText(controller.getCurrentCommandString());
	}

	public void setObserversActiveOrInactive() {
		controller.setObserversActiveOrInactive();
		this.updateObserverListField();
	}

	public void runCommand() {
		commandParser.parseCommand(inputCommand.getText());
		controller.executeLastCommand();
	}

	private void updateObserverListField() {
		observerListString = controller.getObserversListString();
		observerListField.setText(observerListString);
	}

	@Override
	public void HideIfVisibleAndShowIfHidden() {
		updateObserverListField();
		if (this.isVisible()) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
	}

}
