package edu.kis.powp.jobs2d.command.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

	private DriverCommandManager commandManager;

	private JTextArea currentCommandField;

	private String observerListString;
	private JTextArea observerListField;
	private JTextArea inputCommandField;
	private JTextArea inputFileNameField;
	private JScrollPane inputCommandFieldScroll;

	/**
	 *
	 */
	private static final long serialVersionUID = 9204679248304669948L;

	public CommandManagerWindow(DriverCommandManager commandManager) {
		this.setTitle("Command Manager");
		this.setSize(400, 400);
		Container content = this.getContentPane();
		content.setLayout(new GridBagLayout());

		this.commandManager = commandManager;

		GridBagConstraints c = new GridBagConstraints();

		observerListField = new JTextArea("");
		observerListField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(observerListField, c);
		updateObserverListField();

		currentCommandField = new JTextArea("");
		currentCommandField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(currentCommandField, c);
		updateCurrentCommandField();

		inputCommandField = new JTextArea();
		inputCommandFieldScroll = new JScrollPane(inputCommandField);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 10;
		content.add(inputCommandFieldScroll, c);

		inputCommandField.setText("head(-100,-200)\n"
		                          + "cut(100,-200)\n"
		                          + "cut(0,0)\n"
		                          + "cut(-100,-200)\n"
		                          + "head(-100,200)\n"
		                          + "cut(100,200)\n"
		                          + "cut(0,0)\n"
		                          + "cut(-100,200)");

		inputFileNameField = new JTextArea();
		inputCommandFieldScroll = new JScrollPane(inputFileNameField);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 10;
		content.add(inputCommandFieldScroll, c);

		JButton btnLoadCommand = new JButton("Load command");
		btnLoadCommand.addActionListener((ActionEvent e) -> this.loadCommand());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnLoadCommand, c);

		JButton btnLoadFromFileCommand = new JButton("Load command from file");
		btnLoadFromFileCommand.addActionListener((ActionEvent e) -> {
			try {
				this.loatCommandFromFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnLoadFromFileCommand, c);

		JButton btnRunCommand = new JButton("Run command");
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

		JButton btnClearObservers = new JButton("Delete observers");
		btnClearObservers.addActionListener((ActionEvent e) -> this.deleteObservers());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnClearObservers, c);
	}

	private void loadCommand() {
		String rawText = inputCommandField.getText();
		CommandParser co = new BasicCommandParser();
		commandManager.setCurrentCommand(co.createCommansFromString(rawText), "Command from code below");
		updateCurrentCommandField();
	}

	private void loatCommandFromFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(inputFileNameField.getText()));
		String rawText = "";
		String line;
		while((line = in.readLine()) != null)
		{
			rawText += line+"\n";
		}
		in.close();
		inputCommandField.setText(rawText);
		//loadCommand();

	}

	private void runCommand() {
		if(commandManager.getCurrentCommand() != null)
			commandManager.getCurrentCommand().execute(DriverFeature.getDriverManager().getCurrentDriver());
		else
			JOptionPane.showMessageDialog(null, "First set some command :)", "Attention!", JOptionPane.INFORMATION_MESSAGE);
	}

	private void clearCommand() {
		commandManager.clearCurrentCommand();
		updateCurrentCommandField();
	}

	public void updateCurrentCommandField() {
		currentCommandField.setText(commandManager.getCurrentCommandString());
	}

	public void deleteObservers() {
		commandManager.getChangePublisher().clearObservers();
		this.updateObserverListField();
	}

	private void updateObserverListField() {
		observerListString = "";
		List<Subscriber> commandChangeSubscribers = commandManager.getChangePublisher().getSubscribers();
		for (Subscriber observer : commandChangeSubscribers) {
			observerListString += observer.toString() + System.lineSeparator();
		}
		if (commandChangeSubscribers.isEmpty())
			observerListString = "No observers loaded";

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
