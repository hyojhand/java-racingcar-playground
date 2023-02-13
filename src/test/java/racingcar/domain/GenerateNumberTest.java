package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateNumberTest {

    private static final List<Integer> NUMBERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    @Test
    @DisplayName("0~9 사이의 값이 생성된다")
    void random_number_bound_test() {
        GenerateNumber generateNumber = new GenerateNumber();
        int randomNumber = generateNumber.getRandomNumber();

        assertThat(NUMBERS.contains(randomNumber)).isTrue();
    }

}