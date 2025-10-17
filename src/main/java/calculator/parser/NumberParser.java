package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 입력 문자열에서 숫자를 추출하는 클래스입니다.
 */
public class NumberParser {

    private String inputString;
    private String delimiterRegex;

    public NumberParser(String inputString, Set<String> delimiters) {
        this.inputString = setInputString(inputString);
        this.delimiterRegex = String.join("|", delimiters);
    }

    /**
     * 추출기에 저장된 문자열에서 숫자를 추출한다.
     *
     * @return 추출한 숫자 리스트
     */
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
