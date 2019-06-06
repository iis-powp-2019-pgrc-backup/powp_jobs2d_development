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
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

    private DriverCommandManager commandManager;
    private DriverManager driverManager;

    private JTextArea currentCommandField;

    private String observerListString;
    private String commandString;
    private List<String> commands;
    private JTextArea observerListField;
    private JTextArea commandList;
    private JTextField inputCommand;
    private JFileChooser filechooser;
    private CommandParser commandParser;

    private static final long serialVersionUID = 9204679248304669948L;

    public CommandManagerWindow(DriverCommandManager commandManager, DriverManager driverManager, CommandParser commandStringParser) {
        commandParser = commandStringParser;
        this.driverManager = driverManager;
        this.setTitle("Command Manager");
        this.setSize(600, 600);
        Container content = this.getContentPane();
        content.setLayout(new GridBagLayout());

        this.commandManager = commandManager;
        this.commands = new ArrayList<>();
        this.filechooser = new JFileChooser();

        GridBagConstraints c = new GridBagConstraints();

        observerListField = new JTextArea("");
        observerListField.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(observerListField, c);
        updateObserverListField();

        commandList = new JTextArea("");
        commandList.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(commandList, c);
        updateCommandListField();

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

        JButton btnAddCommandToList = new JButton("Add command");
        btnAddCommandToList.addActionListener((ActionEvent e) -> this.addCommandToList());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnAddCommandToList, c);

        JButton btnOpenCommand = new JButton("Open JSON");
        btnOpenCommand.addActionListener((ActionEvent e) -> this.addCommandToListFromJSON());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnOpenCommand, c);

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

        JButton btnClearObservers = new JButton("Delete observers");
        btnClearObservers.addActionListener((ActionEvent e) -> this.deleteObservers());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnClearObservers, c);
    }

    private void clearCommand() {
        if (commandParser != null) {
            commandParser.clearCommands();
            commandList.setText("");
            CommandParser.commandLists.clear();
        }
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

    public void runCommand() {
        commandParser.parseCommand();
        commandManager.runCurrentCommand().execute(driverManager.getCurrentDriver());
    }

    public void addCommandToList() {
        commandParser.addCommand(inputCommand.getText());
        inputCommand.setText("");
        updateCommandListField();
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

    private void addCommandToListFromJSON() {
        filechooser.showOpenDialog(null);
        commandList.setText(filechooser.getSelectedFile().getAbsolutePath());

    }

    private void updateCommandListField() {
        if (commandParser != null) {
            commandList.append(commandParser.getLastCommand() + "\n");
        }
    }

    @Override public void HideIfVisibleAndShowIfHidden() {
        updateObserverListField();
        if (this.isVisible()) {
            this.setVisible(false);
        } else {
            this.setVisible(true);
        }
    }
}
