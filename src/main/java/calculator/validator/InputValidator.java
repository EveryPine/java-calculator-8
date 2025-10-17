package calculator.validator;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력 문자열의 유효성을 검증하는 클래스입니다.
 */
public class InputValidator {

    private final int CUSTOM_DELIM_COUNT = 3;

    private String inputString;
    private String delimiterString;
    private String inputStringRegex;

    public InputValidator(String inputString, Set<String> delimiters) {
        this.inputString = inputString;
        this.delimiterString = setDelimiterString(delimiters);
        this.inputStringRegex = setInputStringRegex();
    }

    /**
     * 저장된 문자열이 유효한지 검증합니다.
     *
     * @return 문자열이 유효하면 true, 유효하지 않으면 false
     */
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

    private String setDelimiterString(Set<String> delimiters) {
        String delimiterString = String.join("", delimiters);
        delimiterString = moveHyphenToEnd(delimiterString);

        return delimiterString;
    }

    private String moveHyphenToEnd(String delimiterString) {
        int hyphenIndex = delimiterString.indexOf("-");
        int middleIndex = 1;

        if (hyphenIndex == middleIndex) {
            delimiterString = delimiterString.replace("-", "") + "-";
        }
        return delimiterString;
    }
}
