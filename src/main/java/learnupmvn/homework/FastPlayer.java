package learnupmvn.homework;

public class FastPlayer implements Movable{
    private int startSpeed;
    private int speedStep;

    public FastPlayer(int startSpeed, int speedStep) {
        this.startSpeed = startSpeed;
        this.speedStep = speedStep;
    }

    @Override
    public int getSpeed() {
        startSpeed += speedStep;
        return startSpeed;
    }

    public static void main(String[] args) {
        FastPlayer player = new FastPlayer(10, 5);
        player.getSpeed();
        player.getSpeed();
        player.getSpeed();
        player.getSpeed();
        System.out.println("Скорость этого игрока равна " + player.getSpeed() + ".");
    }
}
