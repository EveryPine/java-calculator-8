package calculator.controller;

import calculator.parser.DelimiterParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculatorController {

    private final DelimiterParser delimiterParser = new DelimiterParser();

    public Set<String> getDelimiters(String inputString) {
        Set<String> defaultDelimiters = new HashSet<>(List.of(",", ":"));
        Set<String> delimiters = new HashSet<String>(defaultDelimiters);

        if (!inputString.isEmpty()) {
            String customDelimiter = delimiterParser.parseCustomDelimiter(inputString);
            if (!customDelimiter.isEmpty()) {
                delimiters.add(customDelimiter);
            }
        }
        return delimiters;
    }

    public Numbers getNumbers(String inputString, Set<String> delimiters) {

    }
}
