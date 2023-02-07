package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVE_LIMIT_NUMBER = 4;

    private final String name;
    private int moveCount;

    public Car(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다");
        }

        this.name = name;
        this.moveCount = 0;
    }

    public void move(int number) {
        if (number < MOVE_LIMIT_NUMBER) {
            return;
        }

        moveCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
