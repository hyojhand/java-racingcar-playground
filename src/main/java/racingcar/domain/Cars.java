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

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
