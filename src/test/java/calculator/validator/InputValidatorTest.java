package calculator.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InputValidatorTest {

    @BeforeAll
    static void setUp() {

    }

    @ParameterizedTest
    @MethodSource("stringAndSetProvider")
    void validate(String inputString, Set<String> delimiters) {
        // given
        InputValidator inputValidator = new InputValidator(inputString, delimiters);
        boolean expected = true;

        // when
        boolean actual = inputValidator.validate();

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> stringAndSetProvider() {
        return Stream.of(
                arguments("1:2", Set.of(":", ",")),
                arguments("1,2:3", Set.of(":", ",")),
                arguments("//-\\n1-2-3", Set.of(":", ",", "-"))
        );
    }
}