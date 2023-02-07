package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {

    private static final int CAN_MOVE_NUMBER = 4;
    private static final CarGame CAR_GAME = new CarGame();

    @Test
    @DisplayName("승자 이름 테스트")
    void get_winner_test() {
        Cars cars = new Cars("car1,car2");

        for (int i = 0; i < 5; i++) {
            cars.getCars()
                    .forEach(car -> car.move(CAN_MOVE_NUMBER));
        }

        assertThat(CAR_GAME.getWinner(cars)).isEqualTo("car1,car2");
    }

}