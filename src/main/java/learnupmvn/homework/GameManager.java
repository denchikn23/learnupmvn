package learnupmvn.homework;

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

    public int loser(Movable p1, Movable p2, Game game, int rounds){
        int result;
        for (int i = 0; i < rounds; i++){
            boolean flagFirstPlayer = game.isFailed(p1.getSpeed());
            boolean flagSecondPlayer = game.isFailed(p2.getSpeed());

            if ((flagFirstPlayer) & (!(flagSecondPlayer))){
                return -1;
            }
            else if (!(flagFirstPlayer) & ((flagSecondPlayer))){
                return 1;
            }
            else if (!(flagFirstPlayer) & (!(flagSecondPlayer))){
                continue;
            }
            else return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Movable p1 = new FastPlayer(0, 2);
        Movable p2 = new FastPlayer(1, 1);
        Game game = new SpeedyGame(false, 9);
        GameManager manager = new GameManager(game);
        switch (manager.loser(p1, p2, game, 5)){
            case -1:
                System.out.println("1: Первый игрок проиграл раньше второго.");
                break;
            case 1:
                System.out.println("-1: Второй игрок проиграл раньше первого.");
                break;
            case 0 :
                System.out.println("0: Никто из игроков не проиграл.");
                break;
            default:
                System.out.println("2: Оба игрока проиграли в одном раунде.");
                break;
        }
    }
}
