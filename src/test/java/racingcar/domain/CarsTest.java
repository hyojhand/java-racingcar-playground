package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("쉼표로 자동차 이름 구분해서 생성")
    void separate_car_name_test() {
        String carNames = "test,car,name";
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).isEqualTo(List.of(new Car("test"), new Car("car"), new Car("name")));
    }

}