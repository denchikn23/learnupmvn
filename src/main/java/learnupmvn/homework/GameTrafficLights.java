package learnupmvn.homework;
import java.util.Arrays;

public class GameTrafficLights {
    public boolean isGreenLight;
    public int maxSpeed;

    public GameTrafficLights(boolean isGreenLight, int maxSpeed){
        this.isGreenLight = isGreenLight;
        this.maxSpeed = maxSpeed;
    }

    public int numberOfLosers(int[] speed) {
        int count = 0;
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if ((speed[i] < -maxSpeed) | (speed[i] > maxSpeed)){
                    count++;
                }
            }
        }
        return count;
    }

    public int[] speedsOfLosers(int[] speed){
        int count = numberOfLosers(speed);
        int[] arrOfSpeeds = new int[count];
        int countOfLosers = 0; // Всегда не больше, чем количество игроков
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if ((speed[i] < -maxSpeed) | (speed[i] > maxSpeed)){
                    arrOfSpeeds[countOfLosers] = speed[i];
                    countOfLosers++;
                }
            }
        }
        return arrOfSpeeds;
    }

    public int[] speedsOfWinners(int[] speed){
        int count = speed.length - numberOfLosers(speed);
        int[] arrOfSpeeds = new int[count];
        int countOfWinners = 0; // Всегда не больше, чем количество игроков
        if (!isGreenLight) {
            for (int i = 0; i < speed.length; i++){
                if ((speed[i] >= -maxSpeed) & (speed[i] <= maxSpeed)){
                    arrOfSpeeds[countOfWinners] = speed[i];
                    countOfWinners++;
                }
            }
        } else {
            return speed;
        }
        return arrOfSpeeds;
    }
    public String[] nameOfWinners(String[] data){
        int countOfWinners = data.length;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            String[] parts = data[i].split(" ");
            if ((!isGreenLight) & ((Integer.parseInt(parts[1]) < -maxSpeed) | (Integer.parseInt(parts[1]) > maxSpeed))){
                countOfWinners--;
            }
        }

        String[] namesOfWinners = new String[countOfWinners];
        for (int i = 0; i < data.length; i++) {
            String[] parts = data[i].split(" ");
            if ((isGreenLight) | ((!isGreenLight)&((Integer.parseInt(parts[1]) >= -maxSpeed)&(Integer.parseInt(parts[1]) <= maxSpeed)))){
                namesOfWinners[count] = parts[0];
                count++;
            }
        }

        return namesOfWinners;
    }

    public static void main(String[] args) {
        GameTrafficLights gameFirst = new GameTrafficLights(false, 2);
        int[] speed = {3, 0, -2};
        String[] data = {
                "Daniil 3",
                "Filipp 0",
                "Daria -2"
        };

        System.out.println("Количество выбывших игроков : " + gameFirst.numberOfLosers(speed) + '.');
        System.out.println("Массив скоростей выбывших игроков : " + Arrays.toString(gameFirst.speedsOfLosers(speed)) + '.');
        System.out.println("Массив скоростей выигравших игроков : " + Arrays.toString(gameFirst.speedsOfWinners(speed)) + '.');
        System.out.println("Имена выигравших игроков: " + Arrays.toString(gameFirst.nameOfWinners(data)) + '.');
    }
}
