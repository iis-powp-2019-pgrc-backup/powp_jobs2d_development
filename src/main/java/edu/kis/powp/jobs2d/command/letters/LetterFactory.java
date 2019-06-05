package edu.kis.powp.jobs2d.command.letters;

import edu.kis.powp.jobs2d.drivers.DriverManager;

public class LetterFactory {

    private static final String lLetter = "l";

    private static final String uLetter = "u";

    private static final String fLetter = "f";

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
            case fLetter:
                return new FCommandLetter(driverManager.getCurrentDriver());
            default:
                return new NoLetterCommand();
        }
    }
}
