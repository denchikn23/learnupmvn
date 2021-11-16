package learnupmvn.homework;

public class ConstantPlayer implements  Movable {
    private int startSpeed;

    public ConstantPlayer(int speed) {
        this.startSpeed = speed;
    }

    @Override
    public int getSpeed() {
        return startSpeed;
    }

    public static void main(String[] args) {
        ConstantPlayer player = new ConstantPlayer(5);
        player.getSpeed();
        player.getSpeed();
        player.getSpeed();
        player.getSpeed();
        System.out.println("Скорость этого игрока равна " + player.getSpeed() + ".");
    }
}
