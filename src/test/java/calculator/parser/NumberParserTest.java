package calculator.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberParserTest {


    @BeforeAll
    static void setUp() {

    }

    @ParameterizedTest
    @MethodSource("stringSetAndListProvider")
    void parse(String inputString, Set<String> delimiters, List<Long> expected) {
        // given
        NumberParser numberParser = new NumberParser(inputString, delimiters);

        // when
        List<Long> actual = numberParser.parse();

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> stringSetAndListProvider() {
        return Stream.of(
                arguments("1:2", Set.of(":", ","), List.of(1L, 2L)),
                arguments("1,2:3", Set.of(":", ","), List.of(1L, 2L, 3L)),
                arguments("//-\\n1-2-3", Set.of(":", ",", "-"), List.of(1L, 2L, 3L))
        );
    }
}