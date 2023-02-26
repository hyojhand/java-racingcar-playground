package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String CAR_NAME_SEPARATOR = ",";
    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = makeCars(carNames);
    }

    public int getCarsSize() {
        return cars.size();
    }

    public List<Car> findWinners() {
        Position maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
