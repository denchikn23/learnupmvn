package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    public void shouldWorkIfFirstSpeedMoreThanMaxInGame(){
        Game game = new Game(false);
        GameManager gameFirst = new GameManager(game);
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
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если первая скорость больше по модулю максимальной в Game.");
    }

    @Test
    public void shouldWorkIfFirstSpeedMoreThanMaxInSpeedyGame(){
        Game game = new SpeedyGame(false, 6);
        GameManager gameFirst = new GameManager(game);
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
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если первая скорость больше по модулю максимальной в SpeedyGame.");
    }

    @Test
    public void shouldWorkIfAllSpeedNotMoreThanMaxInGame(){
        Game game = new Game(false);
        GameManager gameFirst = new GameManager(game);
        int[] speedInRound = {
                0,
                0,
                0,
                0,
                0,
                0,
                0
        };
        int expected = 7;
        int actual = gameFirst.numberOfRounds(speedInRound);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если все скорости не больше по модулю максимальной.");
    }

    @Test
    public void shouldWorkIfAllSpeedNotMoreThanMaxInSpeedyGame(){
        Game game = new SpeedyGame(false, 4);
        GameManager gameFirst = new GameManager(game);
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
    public void shouldWorkIfGreenLightInGame(){
        Game game = new Game(true);
        GameManager gameFirst = new GameManager(game);
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

    @Test
    public void shouldWorkIfGreenLightInSpeedyGame(){
        Game game = new SpeedyGame(true, 1);
        GameManager gameFirst = new GameManager(game);
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
