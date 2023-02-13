package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarGame {

    public Cars moveOrStop(Cars cars, List<Integer> numbers) {
        if (cars.getCars().size() > numbers.size()) {
            throw new IllegalArgumentException("숫자가 잘못되었습니다");
        }

        int idx = 0;
        for (Car car : cars.getCars()) {
            car.move(numbers.get(idx++));
        }
        return cars;
    }

    public String getWinner(Cars cars) {
        List<String> winners = getWinnerNames(cars);
        return mappingName(winners);
    }

    private List<String> getWinnerNames(Cars cars) {
        int maxMoveCount = getMaxMoveCount(cars);
        return cars.getCars().stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxMoveCount(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private String mappingName(List<String> winners) {
        StringBuilder winner = new StringBuilder();
        for (String name : winners) {
            winner.append(name).append(",");
        }

        return winner.substring(0, winner.toString().length() - 1);
    }
}
