package calculator.controller;

import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.validator.InputValidator;

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

    public void validateInputString(String inputString, Set<String> delimiters) {
        InputValidator inputValidator = new InputValidator(inputString, delimiters);

        if (!inputValidator.validate()) {
            throw new IllegalArgumentException("올바른 형식이 아닙니다.");
        }
        System.out.println("문자열 검증 완료");
    }

    public long calculate(String inputString, Set<String> delimiters) {
        NumberParser numberParser = new NumberParser(inputString, delimiters);
        List<Long> numbers = numberParser.parse();

        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
