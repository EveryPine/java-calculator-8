package calculator;

import calculator.controller.CalculatorController;

import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static CalculatorController controller = new CalculatorController();


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();

        Set<String> delimiters = controller.getDelimiters(inputString);
        controller.validateInputString(inputString, delimiters);

        long result = controller.calculate(inputString, delimiters);
        System.out.println("결과 : " + result);
    }
}
