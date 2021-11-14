package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldWorkWithNegativeSpeed(){
        Game gameFirst = new Game(false);
        int speed = -3;
        boolean expected = true;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с отрицательными скоростями.");
    }

    @Test
    public void shouldWorkWithZeroSpeed(){
        Game gameFirst = new Game(false);
        int speed = 0;
        boolean expected = false;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с нулевой скоростью.");
    }

    @Test
    public void shouldWorkWithGreenLight(){
        Game gameFirst = new Game(true);
        int speed = 10;
        boolean expected = false;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с зеленым светом.");
    }
}
