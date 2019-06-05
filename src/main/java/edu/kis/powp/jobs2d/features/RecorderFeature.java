package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.LoggerDriver;
import edu.kis.powp.jobs2d.command.CompoundCommandImpl;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RecorderFeature {
    private static List<DriverCommand> temporaryDriverCommands;
    private static ICompoundCommand compoundCommand;
    private static boolean isRecording = false;

    public static void startRecording() {
        if (isRecording) {
            throw new IllegalStateException("Record already in progress!");
        }

        isRecording = true;
        if(temporaryDriverCommands == null) temporaryDriverCommands = new ArrayList<>();
        else temporaryDriverCommands.clear();
        Logger.getAnonymousLogger().info("Started recording.");
    }

    public static void stopRecording() {
        if(!isRecording) {
            throw new IllegalStateException("Recording has not begun or is stopped.");
        }

        isRecording = false;
        compoundCommand = new CompoundCommandImpl(temporaryDriverCommands);
        Logger.getAnonymousLogger().info("Stopped recording - click \"Run command\" to replay.");
    }

    public static void toggleRecording() {
        if (isRecording) stopRecording();
        else startRecording();
    }

    public static void record(DriverCommand driverCommand) {
        if (isRecording) temporaryDriverCommands.add(driverCommand);
        else throw new IllegalStateException("Recording has not begun or is stopped.");
    }

    public static ICompoundCommand getRecordedCommands() {
        if(compoundCommand != null)
            return compoundCommand;
        else
            throw new IllegalStateException("Recording never started or never stopped!");
    }

    public static boolean isRecordInProgress() { return isRecording; }
}
