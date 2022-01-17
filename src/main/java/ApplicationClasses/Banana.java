package ApplicationClasses;
import Controllers.GameScreen;
import Controllers.MainScene;

import java.lang.*;
import java.util.Random;


public class Banana {
    private int velocity;
    private double gravity;
    private int angle;


    public Banana(int velocity, double gravity, int angle){
        this.velocity = velocity;
        this.gravity = gravity;
        this.angle = angle;
    }


    public int trajectory(int x) {

        return (int) (-(gravity * Math.pow(x, 2)) /
                (2 * Math.pow((velocity + MainScene.modstand), 2)  * Math.pow(Math.cos(Math.toRadians(angle)), 2))
                + Math.abs(Math.tan(Math.toRadians(angle))) * x);
    }
}