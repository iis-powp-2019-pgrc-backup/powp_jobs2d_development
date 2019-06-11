package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
     static List<CommandHistoryEntry> historyEntries = new ArrayList<CommandHistoryEntry>();

     public void AddEntry(List<DriverCommand> commands, String name){
         historyEntries.add(new CommandHistoryEntry(commands,name));
     }

     class CommandHistoryEntry{
         List<DriverCommand> commands;
         String name;
         CommandHistoryEntry(List<DriverCommand> commands, String name){
             this.commands=commands;
             this.name=name;
         }
     }
}
