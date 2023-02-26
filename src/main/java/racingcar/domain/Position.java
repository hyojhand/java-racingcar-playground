package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        if(position < 0) {
            throw new IllegalStateException("Position은 음수가 될 수 없다");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public Position findMaxPosition(Position maxPosition) {
        return new Position(Math.max(position, maxPosition.position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
