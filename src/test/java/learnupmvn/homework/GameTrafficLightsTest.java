package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTrafficLightsTest {
    @Test
    public void shouldWorkIfThereAreNotPlayers() {
        GameTrafficLights gameFirst = new GameTrafficLights(false, 3);
        int[] speed = {};
        int actual = gameFirst.numberOfLosers(speed);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "Система некорректно работает, если нет игроков.");
    }

    @Test //Подразумевается, что допустимая скорость по модулю должна быть не больше максимальной.
    public void shouldWorkWithNegativeSpeedIfIsNotGreenLight() {
        GameTrafficLights gameFirst = new GameTrafficLights(false, 2);
        int[] speed = {3, -1, -3};
        int[] actual = gameFirst.speedsOfLosers(speed);
        int[] expected = {3, -3};
        Assertions.assertArrayEquals(actual, expected, "Система неправильно считает скорости выбывших игроков с отрицательными скоростями или выводит скорости не в том порядке.");
    }

    @Test
    public void shouldWorkIfSpeedsIsEqualMax() {
        GameTrafficLights gameFirst = new GameTrafficLights(false, 2);
        int[] speed = {2, -2, 2, 2, -2, 2, -2, -2};
        int[] actual = gameFirst.speedsOfWinners(speed);
        int[] expected = {2, -2, 2, 2, -2, 2, -2, -2};
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с максимальной скоростью или выводит скорости не в том порядке.");
    }

    @Test
    public void shouldWorkIfThereAreNotPlayersWithName(){
        GameTrafficLights gameFirst = new GameTrafficLights(false, 2);
        String[] data = {};
        String[] expected = {};
        String[] actual = gameFirst.nameOfWinners(data);
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с выводом имен победивших игроков.");
    }

    @Test
    public void shouldWorkIfSpeedIsEqualMaxWithName(){
        GameTrafficLights gameFirst = new GameTrafficLights(false, 2);
        String[] data = {"Daniil 3",
                "Filipp 0",
                "Daria -2"};
        String[] expected = {"Filipp", "Daria"};
        String[] actual = gameFirst.nameOfWinners(data);
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с выводом имен победивших игроков.");
    }
}
