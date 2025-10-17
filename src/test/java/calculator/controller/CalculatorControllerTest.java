package calculator.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    private static CalculatorController controller;

    @BeforeAll
    static void setup() {
        controller = new CalculatorController();
    }

    @Test
    void getDelimiters() {
        // given
        String inputString = "//-\\n1-2-3";
        Set<String> expected = Set.of(":", ",", "-");

        // when
        Set<String> actual = controller.getDelimiters(inputString);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validateInputString() {
        // given
        String inputString = "//-\\n1-2-3";
        Set<String> delimiters = Set.of(":", ",", "-");

        // when

        // then
        assertDoesNotThrow(() -> controller.validateInputString(inputString, delimiters));
    }

    @Test
    void calculate() {
        // given
        String inputString = "//-\\n1-2-3";
        Set<String> delimiters = Set.of(":", ",", "-");
        long expected = 6;

        // when
        long actual =  controller.calculate(inputString, delimiters);

        // then
        assertEquals(expected, actual);
    }
}