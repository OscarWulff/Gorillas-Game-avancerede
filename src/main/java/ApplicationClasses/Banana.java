/* s.nr. 214927 Morten Lindhardt Helsø */
package ApplicationClasses;
import Controllers.GameScreen;
import Controllers.MainScene;

import java.lang.*;
import java.util.Random;


public class Banana {
    private int velocity;
    private double gravity;
    private int angle;

/* constructs a banana */
    public Banana(int velocity, double gravity, int angle){
        this.velocity = velocity;
        this.gravity = gravity;
        this.angle = angle;
    }

    // the trajectory() method is returning the y-values of the curve ("skråt kast" formula) */
    public int trajectory(int x, int airresistance) {

        return (int) (-(gravity * Math.pow(x, 2)) /
                (2 * Math.pow((velocity + airresistance), 2)  * Math.pow(Math.cos(Math.toRadians(angle)), 2))
                + Math.abs(Math.tan(Math.toRadians(angle))) * x);
    }
}