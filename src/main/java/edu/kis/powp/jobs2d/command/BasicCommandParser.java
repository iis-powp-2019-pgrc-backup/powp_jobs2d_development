package edu.kis.powp.jobs2d.command;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicCommandParser implements CommandParser {
    @Override
    public List<DriverCommand> createCommansFromString(String rawText) {
        rawText = rawText.toLowerCase();
        String [] rawLines = rawText.split("\\n");
        Pattern linePattern = Pattern.compile("(head|cut)\\(\\-?\\d+\\,\\-?\\d+\\)[\\r\\n]?");
        List<DriverCommand> commands = new LinkedList<>();

        for(String s : rawLines)
        {
            Matcher matcher = linePattern.matcher(s);
            if(!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Incorrect command! Don't use spaces between anything and floating numbers.", "Attention!", JOptionPane.ERROR_MESSAGE);
            }

            DriverCommand command = null;

            int firstParenthesis = s.indexOf("(");
            int commaPos = s.indexOf(",");
            int firstValue = Integer.parseInt(s.substring(firstParenthesis + 1, commaPos));
            int secondValue = Integer.parseInt(s.substring(commaPos + 1, s.length() - 1));

            if(s.startsWith("head")) {
                command = new SetPositionCommand(firstValue, secondValue);
            }
            else if(s.startsWith("cut")) {
                command = new OperateToCommand(firstValue,secondValue);
            }

            commands.add(command);

        }
        return commands;
    }
}
