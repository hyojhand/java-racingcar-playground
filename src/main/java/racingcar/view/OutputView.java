package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String MOVE_ICON = "-";

    public void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    public void printResult(Cars cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            result.append(getResult(car.getName(), car.getMoveCount()));
        }

        System.out.println(result);
    }

    private String getResult(String name, int count) {
        return name + " : " + getMoveIcon(count) + '\n';
    }

    private String getMoveIcon(int count) {
        return MOVE_ICON.repeat(count);
    }
}
