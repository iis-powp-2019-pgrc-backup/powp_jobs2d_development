package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfCommandsFromJTextArea implements ISourceToDraw {

    // EXAMPLE CODE TO DRAW SQUARE: (s,0,0);(o,100,0);(o,100,100);(o,0,100);(o,0,0);

    @Override
    public List<DriverCommand> CommandsToDraw(String stringFromJTextArea) {
        List<String> listaElementow = splitStringsToCommands(stringFromJTextArea);
        List<String> listaBezNawiasow = getStringsWithoutBrackets(listaElementow);
        List<String[]> listaBezPrzecinkow = splitStringsByComa(listaBezNawiasow);

        for (String[] strings : listaBezPrzecinkow) {
            System.out.println(strings[0]+ " " + strings[1]+ " " + strings[2]);
        }

        List<DriverCommand> commands = new ArrayList<DriverCommand>();
        for(String[] str : listaBezPrzecinkow){
            if(str[0].equals("s")){
                commands.add(new SetPositionCommand(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            }
            if(str[0].equals("o")){
                commands.add(new OperateToCommand(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            }
        }

        return commands;
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

    public List<String> splitStringsToCommands(String textArea) {
        List<String> listaOperacji = Arrays.asList(textArea.split(";"));
        return listaOperacji;
    }
}
