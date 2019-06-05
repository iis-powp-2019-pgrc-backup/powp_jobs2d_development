package edu.kis.powp.jobs2d.command.letters;

import edu.kis.powp.jobs2d.drivers.DriverManager;

public class LetterFactory {

    // TODO: change it to specific code
    private static final String lLetter = "L";

    private static final String uLetter = "U";

    private DriverManager driverManager;

    public LetterFactory(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public ComplexCommand create(String letterCode) {
        switch (letterCode) {
            case lLetter:
                return new LCommandLetter(driverManager.getCurrentDriver());
            case uLetter:
                return new UCommandLetter(driverManager.getCurrentDriver());
            default:
                return null;
        }
    }
}
