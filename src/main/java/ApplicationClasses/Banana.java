package ApplicationClasses;
import java.lang.*;

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
        int y = 1;
        while (y >= 0){
            y = (int) (gravity / (2 * velocity ^ 2) * (Math.cos(angle))) * x ^ 2 + (int) Math.tan(angle) * x;
            x++;
        }
        return x;
    }
}