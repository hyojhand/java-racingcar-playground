package racingcar.domain;

import java.util.List;

public class CarGame {

    public Cars moveOrStop(Cars cars, List<Integer> numbers) {
        if (cars.getCarsSize() > numbers.size()) {
            throw new IllegalArgumentException("숫자가 잘못되었습니다");
        }

        int idx = 0;
        for (Car car : cars.getCars()) {
            car.move(numbers.get(idx++));
        }
        return cars;
    }

    public List<Car> getWinners(Cars cars) {
        return cars.findWinners();
    }
}
