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
    private static final GenerateNumber generateNumber = new GenerateNumber();

    public static void start() {
        String carNames = INPUT_VIEW.inputCarName();
        Cars cars = new Cars(carNames);

        int gameCount = Integer.parseInt(INPUT_VIEW.inputGameCount());
        CarGame carGame = new CarGame();
        play(carGame, cars, gameCount);

        OUTPUT_VIEW.printResult(cars);
        OUTPUT_VIEW.printWinner(carGame.getWinners(cars));
    }

    private static void play(CarGame carGame, Cars cars, int gameCount) {
        while (gameCount > 0) {
            List<Integer> randoms = new ArrayList<>();
            for (int i = 0; i < cars.getCarsSize(); i++) {
                randoms.add(generateNumber.getRandomNumber());
            }

            OUTPUT_VIEW.printResult(carGame.moveOrStop(cars, randoms));
            gameCount--;
        }
    }
}
