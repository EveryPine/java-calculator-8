package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberParser {

    private String inputString;
    private String delimiterRegex;

    public NumberParser(String inputString, Set<String> delimiters) {
        this.inputString = setInputString(inputString);
        this.delimiterRegex = String.join("|", delimiters);
    }

    public List<Long> parse() {
        String[] numbers = inputString.split(delimiterRegex);

        return Arrays.stream(numbers)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private String setInputString(String inputString) {
        if (inputString.startsWith("//")) {
            inputString = inputString.substring(5);
        }
        return inputString;
    }
}
