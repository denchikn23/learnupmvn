package ru.learnup.javaqa.learnupmvn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class GameTrafficLightsTest {
    @Test
    public void shouldWorkIfThereAreNotPlayers() {
        int[] speed = {};
        int actual = GameTrafficLights.numberOfLosers(speed);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "Система некорректно работает, если нет игроков.");
    }

    @Test
    public void shouldWorkWithNegativeSpeedIfIsNotGreenLight() {
        int[] speed = {3, -1, 0};
        int[] actual = GameTrafficLights.speedsOfLosers(speed);
        int[] expected = {3, -1};
        Assertions.assertArrayEquals(actual, expected, "Система неправильно считает скорости выбывших игроков с отрицательными скоростями или выводит скорости не в том порядке.");
    }

    @Test
    public void shouldWorkIfIsGreenLight() {
        int[] speed = {3, -1, 0};
        int[] actual = GameTrafficLights.speedsOfWinners(speed);
        int[] expected = {3, -1, 0};
        Assertions.assertArrayEquals(actual, expected, "Система некорректно работает с зеленым светом или выводит скорости не в том порядке.");
    }
}
