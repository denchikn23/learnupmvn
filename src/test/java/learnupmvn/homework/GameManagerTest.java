package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    @Test
    public void shouldWorkIfFirstSpeedMoreThanMax(){
        GameManager gameFirst = new GameManager(false, 3);
        int[] speedInRound = {
                7,
                -1,
                1,
                -2,
                2,
                -3,
                3,
                -4,
                4,
                -5,
                5
        };
        int expected = 0;
        int actual = gameFirst.numberOfRounds(speedInRound);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если первая скорость больше по модулю максимальной.");
    }

    @Test
    public void shouldWorkIfAllSpeedNotMoreThanMax(){
        GameManager gameFirst = new GameManager(false, 3);
        int[] speedInRound = {
                0,
                -1,
                1,
                -2,
                2,
                -3,
                3
        };
        int expected = 7;
        int actual = gameFirst.numberOfRounds(speedInRound);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если все скорости не больше по модулю максимальной.");
    }

    @Test
    public void shouldWorkIfGreenLight(){
        GameManager gameFirst = new GameManager(true, 0);
        int[] speedInRound = {
                0,
                -1,
                1,
                -2,
                2,
                -3,
                3,
                -4,
                4,
                -5,
                5
        };
        int expected = 11;
        int actual = gameFirst.numberOfRounds(speedInRound);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с зеленым светом.");
    }
}
