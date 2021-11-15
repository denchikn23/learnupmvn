package learnupmvn.homework;

import lombok.Data;

public class GameManager {
    private boolean isGreenLight;
    private int maxSpeed;

    public GameManager(boolean isGreenLight, int maxSpeed) {
        this.isGreenLight = isGreenLight;
        this.maxSpeed = maxSpeed;
    }

    public int numberOfRounds(int[] speedInRound){
        int countOfRounds = 0;
        if (!isGreenLight){
            for (int i = 0; i < speedInRound.length; i++){
                if ((speedInRound[i] >= -maxSpeed) & (speedInRound[i] <= maxSpeed)){
                    countOfRounds++;
                }
                else return countOfRounds;
            }
            return countOfRounds;
        }
        return speedInRound.length;
    }

    public static void main(String[] args) {
        GameManager gameFirst = new GameManager(false, 3);
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
        System.out.println("Игрок продержится раундов: " + gameFirst.numberOfRounds(speedInRound));
    }
}
