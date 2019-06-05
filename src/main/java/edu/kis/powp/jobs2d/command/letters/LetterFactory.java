package edu.kis.powp.jobs2d.command.letters;

public class LetterFactory {

    // TODO: change it to specific code
    private static final String lLetter = "L";

    private static final String uLetter = "U";

    public ComplexCommand create(String letterCode) {
        switch (letterCode) {
            case lLetter:
                return new LCommandLetter();
            case uLetter:
                return new UCommandLetter();
            default:
                return null;
        }
    }
}
