package calculator.controller;

import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.validator.InputValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 문자열 덧셈 계산기의 주요 기능을 수행하는 클래스입니다.
 */
public class CalculatorController {

    private final DelimiterParser delimiterParser = new DelimiterParser();

    /**
     * 기본 구분자(",", ":")와 커스텀 구분자를 포함한 집합을 반환한다.
     *
     * @param inputString   입력받은 문자열
     * @return 기본 구분자와 커스텀 구분자가 포함된 문자열 집합
     */
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

    /**
     * 입력받은 문자열이 유효한지 검증한다.
     * @param   inputString     입력 문자열
     * @param   delimiters      구분자 집합
     * @throws  IllegalArgumentException
     *          입력 문자열이 {@link InputValidator#validate()} 결과에 따라 유효하지 않은 경우
     */
    public void validateInputString(String inputString, Set<String> delimiters) {
        InputValidator inputValidator = new InputValidator(inputString, delimiters);

        if (!inputValidator.validate()) {
            throw new IllegalArgumentException("올바른 형식이 아닙니다.");
        }
        System.out.println("문자열 검증 완료");
    }

    /**
     * 입력 문자열에서 숫자를 추출하고, 각 숫자의 합을 반환합니다.
     * @param inputString   입력 문자열
     * @param delimiters    구분자 집합
     * @return 문자열에서 추출한 숫자들의 합
     */
    public long calculate(String inputString, Set<String> delimiters) {
        NumberParser numberParser = new NumberParser(inputString, delimiters);
        List<Long> numbers = numberParser.parse();

        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
