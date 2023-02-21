package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_LIMIT_NUMBER = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int moveCount) {
        this.name = new Name(name);
        this.position = new Position(moveCount);
    }

    public void move(int number) {
        if (number >= MOVE_LIMIT_NUMBER) {
            position = position.move();
        }
    }

    public Position findMaxPosition(Position maxPosition) {
        return position.findMaxPosition(maxPosition);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getPosition());
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
