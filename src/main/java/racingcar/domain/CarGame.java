package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarGame {

    private static final GenerateNumber generateNumber = new GenerateNumber();

    public Cars moveOrStop(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(generateNumber.getRandomNumber());
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
