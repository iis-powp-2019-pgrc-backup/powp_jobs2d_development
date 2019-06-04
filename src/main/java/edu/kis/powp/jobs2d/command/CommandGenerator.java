package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CommandGenerator implements Job2dDriver, ActionListener {

  static  private List<DriverCommand> commands = new ArrayList<>();

    public CommandGenerator() {

        commands.add(new SetPositionCommand(1, 1));
    }

    @Override
    public void setPosition(int x, int y) {
        commands.add(new SetPositionCommand(x, y));
    }

    @Override
    public void operateTo(int x, int y) {
        commands.add(new OperateToCommand(x, y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String string = "";
        if (commands.isEmpty()) {
            string += "No command";
        } else {

            for (DriverCommand command : commands) {
                string +=command.toString();
                string += "\n";
            }
        }
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, string);
    }


}
