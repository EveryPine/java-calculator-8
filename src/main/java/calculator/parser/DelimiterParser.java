package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력 문자열에서 커스텀 구분자를 추출하는 클래스입니다.
 */
public class DelimiterParser {

    private final String CUSTOM_DELIM_REGEX = "^//\\D+\\\\n";

    /**
     * 입력 문자열에서 커스텀 구분자를 추출합니다.
     *
     * @param inputString 입력 문자열
     * @return 커스텀 구분자 문자열
     */
    public String parseCustomDelimiter(String inputString) {
        String customDelimiter = "";
        Pattern pattern = Pattern.compile(CUSTOM_DELIM_REGEX);
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            customDelimiter = matcher.group()
                    .replace("//", "")
                    .replace("\\n", "");
        }
        return customDelimiter;
    }
}
