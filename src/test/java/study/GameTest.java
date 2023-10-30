package study;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.RacingCar;

public class GameTest {

    @Test
    @DisplayName("모든 랜덤값이 4보다 작을경우 모두 전진하지 않는다.")
    void 전진x(){
        RacingCar racingCar = setUpRacingCar();
        assertRaceResult(racingCar, Arrays.asList(1, 2, 3), Arrays.asList(0, 0, 0));
    }
    @Test
    @DisplayName("랜덤값 1개가 4보다 크거가 같을 경우 하나만 전진한다.")
    void 전진1개(){
        RacingCar racingCar = setUpRacingCar();
        assertRaceResult(racingCar, Arrays.asList(1, 6, 3), Arrays.asList(0, 1, 0));
    }
    @Test
    @DisplayName("랜덤값 2개가 4보다 크거가 같을 경우 두개만 전진한다.")
    void 전진2개(){
        RacingCar racingCar = setUpRacingCar();
        assertRaceResult(racingCar, Arrays.asList(7, 6, 3), Arrays.asList(1, 1, 0));
    }
    @Test
    @DisplayName("모든 랜덤값이 4보다 크거나 같을경우 모두 전진한다.")
    void 전진o(){
        RacingCar racingCar = setUpRacingCar();
        assertRaceResult(racingCar, Arrays.asList(4, 4, 6), Arrays.asList(1, 1, 1));
    }

    private static void assertRaceResult(RacingCar racingCar, List<Integer> randomValue, List<Integer> expectedValue) {
        Game game = new Game();
        List<Integer> randomNumbers = randomValue;
        game.updateRaceResult(randomNumbers, racingCar);
        Assertions.assertThat(racingCar.getRaceResult()).isEqualTo(expectedValue);
    }

    private static RacingCar setUpRacingCar() {
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars("pobi,crong,jun");
        racingCar.updateRaceCount("3");
        return racingCar;
    }
}