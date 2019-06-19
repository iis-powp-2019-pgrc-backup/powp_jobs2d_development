package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManagerWindow extends JFrame implements WindowComponent {

    private DriverCommandManager commandManager;

    private JTextArea currentCommandField;

    private String observerListString;
    private JTextArea observerListField;

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

        // POLE DO WPISYWANIA KOMEND
        JTextArea jTextArea = new JTextArea();
        content.add(jTextArea, c);

        JButton btnSendText = new JButton("Save figure to draw");
        btnSendText.addActionListener((ActionEvent e) -> { //*************************************************************

            ParseStringFromTextAreaToOperateCommand(jTextArea);

        });
        content.add(btnSendText, c);


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

    private void ParseStringFromTextAreaToOperateCommand(JTextArea jTextArea) {
        List<String> listaElementow = parseStringToCommand(jTextArea.getText());
        List<String> listaBezNawiasow = getStringsWithoutBrackets(listaElementow);
        List<String[]> listaBezPrzecinkow = splitStringsByComa(listaBezNawiasow);

        for (String[] strings : listaBezPrzecinkow) {
            System.out.println(strings[0]+ " " + strings[1]+ " " + strings[2]);
        }
    }

    private List<String> getStringsWithoutBrackets(List<String> listaElementow) {
        List<String> listaBezNawiasow = new ArrayList<>();
        for (String s : listaElementow) {
            listaBezNawiasow.add(s.substring(1, s.length() - 1));
        }

        return listaBezNawiasow;
    }

    private List<String[]> splitStringsByComa(List<String> listaBezNawiasow) {
        List<String[]> listaBezPrzecinkow = new ArrayList<>();
        for (String s : listaBezNawiasow) {
            listaBezPrzecinkow.add(s.split(","));
        }
        return listaBezPrzecinkow;
    }

    public List<String> parseStringToCommand(String textArea) {
        List<String> listaOperacji = Arrays.asList(textArea.split(";"));
        return listaOperacji;
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
