package calculator.validator;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private final int CUSTOM_DELIM_COUNT = 3;

    private String inputString;
    private String delimiterString;
    private String inputStringRegex;

    public InputValidator(String inputString, Set<String> delimiters) {
        this.inputString = inputString;
        this.delimiterString = String.join("", delimiters);
        this.inputStringRegex = setInputStringRegex();
    }

    public boolean validate() {
        boolean isValid = true;
        Matcher matcher = Pattern.compile(inputStringRegex).matcher(inputString);

        if (inputString == null || !matcher.find()) {
            isValid = false;
        }

        return isValid;
    }

    private String setInputStringRegex() {
        String inputStringRegex = "^(\\d+([" + delimiterString + "]\\d+)*)?$";
        if (delimiterString.length() == CUSTOM_DELIM_COUNT) {
            inputStringRegex = "^//\\D\\\\n" + inputStringRegex.substring(1);
        }
        return inputStringRegex;
    }
}
