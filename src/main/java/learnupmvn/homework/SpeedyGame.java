package learnupmvn.homework;

import lombok.Data;

@Data
public class SpeedyGame extends Game {
    private int maxSpeed;

    public SpeedyGame(boolean isGreenLight, int maxSpeed){
        super(isGreenLight);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        System.out.println("Максимальная скорость по модулю: " + maxSpeed);
        return maxSpeed;
    }

    @Override
    public boolean isFailed(int speed){
        boolean flag = false;
        if (!isGreenLight){
            if ((speed < -maxSpeed)|(speed > maxSpeed)){
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int speed = 3;
        boolean isGreenLight = true;
        int maxSpeed = 3;

        SpeedyGame gameFirst = new SpeedyGame(isGreenLight, maxSpeed);
        gameFirst.getGreenLight();
        gameFirst.getMaxSpeed();
        gameFirst.resultGame(isGreenLight, speed);

        isGreenLight = false;
        gameFirst.setGreenLight(isGreenLight);
        gameFirst.getGreenLight();
        gameFirst.getMaxSpeed();
        gameFirst.resultGame(isGreenLight, speed);

        maxSpeed = 2;
        gameFirst.setMaxSpeed(maxSpeed);
        gameFirst.getGreenLight();
        gameFirst.getMaxSpeed();
        gameFirst.resultGame(isGreenLight, speed);
    }
}
