package learnupmvn.homework;

import lombok.Data;

public class GameManager {
    private Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public int numberOfRounds(int[] speedInRound){
        int countOfRounds = 0;
        for (int i = 0; i < speedInRound.length; i++){
            if (!game.isFailed(speedInRound[i])){
                countOfRounds++;
            }
            else return countOfRounds;
        }
        return countOfRounds;
    }

    public static void main(String[] args) {
        Game game = new Game(false);
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
        System.out.println("Игрок продержится раундов: " + gameFirst.numberOfRounds(speedInRound) + ".");
    }
}
