package calculator.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterParserTest {

    private static DelimiterParser delimiterParser;

    @BeforeAll
    static void setUp() {
        delimiterParser = new DelimiterParser();
    }

    @Test
    void parseCustomDelimiter() {
        // given
        String inputString = "//-\\n1-2-3";
        String expected = "-";

        // when
        String actual = delimiterParser.parseCustomDelimiter(inputString);

        // then
        assertEquals(expected, actual);
    }
}