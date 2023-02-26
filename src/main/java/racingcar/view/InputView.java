package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputCarName() {
        return inputValue("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
    }

    public String inputGameCount() {
        return inputValue("시도할 회수는 몇회인가요?");
    }

    private String inputValue(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
