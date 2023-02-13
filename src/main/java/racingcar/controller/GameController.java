package racingcar.controller;

import racingcar.domain.CarGame;
import racingcar.domain.Cars;
import racingcar.domain.GenerateNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final CarGame CAR_GAME = new CarGame();
    private static final GenerateNumber generateNumber = new GenerateNumber();

    public static void start() {
        String carNames = INPUT_VIEW.inputCarName();
        int gameCount = Integer.parseInt(INPUT_VIEW.inputGameCount());

        Cars cars = new Cars(carNames);
        play(cars, gameCount);

        OUTPUT_VIEW.printResult(cars);
        OUTPUT_VIEW.printWinner(CAR_GAME.getWinner(cars));
    }

    private static void play(Cars cars, int gameCount) {
        while (gameCount > 0) {
            List<Integer> randoms = new ArrayList<>();
            int size = cars.getCars().size();
            for (int i = 0; i < size; i++) {
                randoms.add(generateNumber.getRandomNumber());
            }

            OUTPUT_VIEW.printResult(CAR_GAME.moveOrStop(cars, randoms));
            gameCount--;
        }
    }
}
