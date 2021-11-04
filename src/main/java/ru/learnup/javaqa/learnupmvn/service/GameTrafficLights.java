package ru.learnup.javaqa.learnupmvn.service;
import java.util.Arrays;

public class GameTrafficLights {
    public static boolean isGreenLight = true;

    public static int numberOfLosers(int[] speed) {
        int count = 0;
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if (speed[i] != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] speedsOfLosers(int[] speed){
        int count = numberOfLosers(speed);
        int[] arrOfSpeeds = new int[count];
        int countOfLosers = 0; // Всегда не больше, чем количество игроков
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if (speed[i] != 0){
                    arrOfSpeeds[countOfLosers] = speed[i];
                    countOfLosers++;
                }
            }
        }
        return arrOfSpeeds;
    }

    public static int[] speedsOfWinners(int[] speed){
        int count = speed.length - numberOfLosers(speed);
        int[] arrOfSpeeds = new int[count];
        int countOfWinners = 0; // Всегда не больше, чем количество игроков
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if (speed[i] == 0){
                    arrOfSpeeds[countOfWinners] = speed[i];
                    countOfWinners++;
                }
            }
        } else {
            return speed;
        }
        return arrOfSpeeds;
    }

    public static void main(String[] args) {
        int[] speed = {3, 0, 2};

        System.out.println("Количество выбывших игроков : " + numberOfLosers(speed));
        System.out.println("Массив скоростей выбывших игроков : " + Arrays.toString(speedsOfLosers(speed)));
        System.out.println("Массив скоростей выигравших игроков : " + Arrays.toString(speedsOfWinners(speed)));
    }
}
