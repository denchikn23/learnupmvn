package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedyGameTest {
    @Test
    public void shouldWorkWithNegativeSpeed(){
        SpeedyGame gameFirst = new SpeedyGame(false, 2);
        int speed = -3;
        boolean expected = true;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с отрицательными скоростями.");
    }

    @Test
    public void shouldWorkWithMaxSpeed(){
        SpeedyGame gameFirst = new SpeedyGame(false, 3);
        int speed = 3;
        boolean expected = false;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с максимальной скоростью.");
    }

    @Test
    public void shouldWorkWithGreenLight(){
        SpeedyGame gameFirst = new SpeedyGame(true, 5);
        int speed = 10;
        boolean expected = false;
        boolean actual = gameFirst.isFailed(speed);
        Assertions.assertEquals(expected, actual, "Система некорректно работает с зеленым светом.");
    }

}
