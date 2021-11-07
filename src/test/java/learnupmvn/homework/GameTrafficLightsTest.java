package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTrafficLightsTest {
    @Test
    public void shouldWorkIfThereAreNotPlayers() {
        GameTrafficLights.isGreenLight = true;
        int[] speed = {};
        int actual = GameTrafficLights.numberOfLosers(speed);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "Система некорректно работает, если нет игроков.");
    }

    @Test //Подразумевается, что допустимая скорость по модулю должна быть не больше максимальной.
    public void shouldWorkWithNegativeSpeedIfIsNotGreenLight() {
        GameTrafficLights.isGreenLight = false;
        int[] speed = {3, -1, -3};
        int[] actual = GameTrafficLights.speedsOfLosers(speed);
        int[] expected = {3, -3};
        Assertions.assertArrayEquals(actual, expected, "Система неправильно считает скорости выбывших игроков с отрицательными скоростями или выводит скорости не в том порядке.");
    }

    @Test
    public void shouldWorkIfSpeedsIsEqualMax() {
        GameTrafficLights.isGreenLight = false;
        int[] speed = {2, -2, 2, 2, -2, 2, -2, -2};
        int[] actual = GameTrafficLights.speedsOfWinners(speed);
        int[] expected = {2, -2, 2, 2, -2, 2, -2, -2};
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с максимальной скоростью или выводит скорости не в том порядке.");
    }

    @Test
    public void shouldWorkIfThereAreNotPlayersWithName(){
        GameTrafficLights.isGreenLight = false;
        String[] data = {};
        String[] expected = {};
        String[] actual = GameTrafficLights.nameOfWinners(data);
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с выводом имен победивших игроков.");
    }

    @Test
    public void shouldWorkIfSpeedIsEqualMaxWithName(){
        GameTrafficLights.isGreenLight = false;
        String[] data = {"Daniil 3",
                "Filipp 0",
                "Daria -2"};
        String[] expected = {"Filipp", "Daria"};
        String[] actual = GameTrafficLights.nameOfWinners(data);
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с выводом имен победивших игроков.");
    }
}


