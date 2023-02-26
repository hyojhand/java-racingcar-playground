package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateNumber {

    private static final List<Integer> NUMBERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    public int getRandomNumber() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.get(0);
    }

}
