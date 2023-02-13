package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarGameTest {

    private static final int CAN_MOVE_NUMBER = 4;
    private static final int CANNOT_MOVE_NUMBER = 3;
    private static final CarGame CAR_GAME = new CarGame();

    @Test
    @DisplayName("car1은 정지, car2는 움직이는 테스트")
    void moveOrStop_test() {
        Cars cars = new Cars("car1,car2");

        List<Integer> numbers = List.of(CANNOT_MOVE_NUMBER, CAN_MOVE_NUMBER);
        CAR_GAME.moveOrStop(cars, numbers);

        Assertions.assertAll(
                () -> assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(0),
                () -> assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Cars 보다 작은 갯수 값이 들어올때 예외 테스트")
    void numbers_size_exception_test() {
        Cars cars = new Cars("car1,car2,car3");
        List<Integer> numbers = List.of(CANNOT_MOVE_NUMBER, CAN_MOVE_NUMBER);

        assertThatThrownBy(() -> CAR_GAME.moveOrStop(cars, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 잘못되었습니다");
    }

    @Test
    @DisplayName("승자가 한명 테스트")
    void only_one_winner_test() {
        Cars cars = new Cars("car1,car2");

        List<Integer> numbers = List.of(CAN_MOVE_NUMBER, CANNOT_MOVE_NUMBER);
        CAR_GAME.moveOrStop(cars, numbers);

        assertThat(CAR_GAME.getWinner(cars)).isEqualTo("car1");
    }

    @Test
    @DisplayName("승자가 여러명 테스트")
    void several_winner_test() {
        Cars cars = new Cars("car1,car2");

        List<Integer> numbers = List.of(CAN_MOVE_NUMBER, CAN_MOVE_NUMBER);
        CAR_GAME.moveOrStop(cars, numbers);

        assertThat(CAR_GAME.getWinner(cars)).isEqualTo("car1,car2");
    }

}