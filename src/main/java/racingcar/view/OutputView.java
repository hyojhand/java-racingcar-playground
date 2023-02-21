package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    private static final String MOVE_ICON = "-";

    public void printWinner(List<Car> winners) {
        System.out.println(mappingName(winners) + "가 최종 우승했습니다.");
    }

    public void printResult(Cars cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            result.append(getResult(car.getName().getName(), car.getPosition().getPosition()));
        }

        System.out.println(result);
    }

    private String mappingName(List<Car> winners) {
        StringBuilder winner = new StringBuilder();
        for (Car car : winners) {
            winner.append(car.getName()).append(",");
        }

        return winner.substring(0, winner.toString().length() - 1);
    }

    private String getResult(String name, int count) {
        return name + " : " + getMoveIcon(count) + '\n';
    }

    private String getMoveIcon(int count) {
        return MOVE_ICON.repeat(count);
    }
}
