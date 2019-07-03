package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.CommandHistory;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.util.List;

public class SelectListOptionListener implements javax.swing.event.ListSelectionListener {
    private final JList commandHistoryList;
    private final DriverCommandManager commandManager;

    public SelectListOptionListener(JList commandHistoryList, DriverCommandManager commandManager) {
        this.commandHistoryList = commandHistoryList;
        this.commandManager = commandManager;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {

            if (commandHistoryList.getSelectedIndex() != -1) {
                int index = commandHistoryList.getSelectedIndex();
                List commands = CommandHistory.getCommandsFromList(index);
                String commandsName = (String) commandHistoryList.getSelectedValue();

                commandManager.setCurrentCommand(commands,commandsName);
            }
        }
    }
}
