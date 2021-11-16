package learnupmvn.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    public void shouldWorkIfBothPlayersAreConstantAndWonInGame(){
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new ConstantPlayer(0);
        Game game = new Game(false);
        GameManager manager = new GameManager(game);

        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если оба константных игрока не проиграли в обычной игре.");
    }

    @Test
    public void shouldWorkIfBothPlayersArtFastAndLostInSpeedyGame(){
        Movable p1 = new FastPlayer(0, 2);
        Movable p2 = new FastPlayer(3, 1);
        Game game = new SpeedyGame(false, 6);
        GameManager manager = new GameManager(game);

        int expected = 2;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если оба быстрых игрока проиграли в скоростной игре.");
    }

    @Test
    public void shouldWorkIfFirstPlayerIsConstantAndLostInSpeedyGame(){
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(0, 1);
        Game game = new SpeedyGame(false, 3);
        GameManager manager = new GameManager(game);

        int expected = -1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если первый игрок константный и проиграл в скоростной игре.");
    }

    @Test
    public void shouldWorkIfSecondPlayerIsSpeedyAndLostInGame(){
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 1);
        Game game = new Game(false);
        GameManager manager = new GameManager(game);

        int expected = 1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если второй игрок быстрый и проиграл в игре.");
    }

    @Test
    public void shouldWorkIfNotRounds(){
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(0, 1);
        Game game = new SpeedyGame(false, 3);
        GameManager manager = new GameManager(game);

        int expected = 0;
        int actual = manager.loser(p1, p2, game, 0);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если число раундов равно 0.");
    }

    @Test
    public void shouldWorkIfGreenLight(){
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(0, 1);
        Game game = new SpeedyGame(true, 3);
        GameManager manager = new GameManager(game);

        int expected = 0;
        int actual = manager.loser(p1, p2, game, 0);
        Assertions.assertEquals(expected, actual, "Система некорректно работает, если горит зеленый свет.");
    }
}
