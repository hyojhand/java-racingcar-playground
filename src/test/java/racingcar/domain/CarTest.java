package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("Car 객체 테스트")
    void create_car_test() {
        Car car = new Car("sonny");
        assertThat(car).isEqualTo(new Car("sonny"));
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하지 않는다")
    void car_name_under_five_test() {
        assertThatThrownBy(() -> new Car("veryLongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없다");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상이면 자동차가 움직인다")
    void move_car(int number) {
        Car car = new Car("name");
        car.move(number);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4미만이면 자동차가 움직이지 않는다")
    void not_move_car(int number) {
        Car car = new Car("name");
        car.move(number);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

}