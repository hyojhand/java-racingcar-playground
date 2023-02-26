package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @Test
    @DisplayName("Car 객체 테스트")
    void create_car_test() {
        Car car = new Car("sonny");
        assertThat(car).isEqualTo(new Car("sonny"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상이면 자동차가 움직인다")
    void move_car(int number) {
        Car car = new Car("name");
        car.move(number);
        assertThat(car).isEqualTo(new Car("name", 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4미만이면 자동차가 움직이지 않는다")
    void not_move_car(int number) {
        Car car = new Car("name");
        car.move(number);
        assertThat(car).isEqualTo(new Car("name", 0));
    }

    @Test
    @DisplayName("최대 위치와 같으면 승자임을 테스트")
    void winner_test() {
        Car car = new Car("son", 3);
        Car anotherCar = new Car("hyo", 2);
        Position maxPosition = new Position(3);
        assertAll(
                () -> assertThat(car.isWinner(maxPosition)).isTrue(),
                () -> assertThat(anotherCar.isWinner(maxPosition)).isFalse()
        );
    }
}