package learnupmvn.homework;

import lombok.Data;

@Data
public class Game {
    protected boolean isGreenLight;

    public Game(){}

    public Game(boolean isGreenLight){
        this.isGreenLight = isGreenLight;
    }

    public boolean getGreenLight() {
        return isGreenLight;
    }

    public boolean isFailed(int speed){
        boolean flag = false;
        if (!isGreenLight){
            if (speed != 0){
                flag = true;
            }
        }
        return flag;
    }

    public void resultGame(boolean isGreenLight, int speed){
        if (isFailed(speed)){
            System.out.println("Игрок со скоростью " + speed + " проиграл.");
        }
        else {
            System.out.println("Игрок со скоростью " + speed + " выиграл.");
        }
    }

    public static void main(String[] args) {
        int speed = 3;
        boolean isGreenLight = true;

        Game gameFirst = new Game(isGreenLight);
        gameFirst.getGreenLight();
        gameFirst.resultGame(isGreenLight, speed);

        isGreenLight = false;
        gameFirst.setGreenLight(isGreenLight);
        gameFirst.getGreenLight();
        gameFirst.resultGame(isGreenLight, speed);
    }
}
