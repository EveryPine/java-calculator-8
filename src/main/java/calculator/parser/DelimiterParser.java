package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private final String CUSTOM_DELIM_REGEX = "^//\\D+\\\\n";

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
