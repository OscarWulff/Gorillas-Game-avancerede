package ApplicationClasses;

import ApplicationClasses.*;
import Controllers.GameScreen;

import java.util.TimerTask;


public class TimeAdder extends TimerTask{
    int i;

    public TimeAdder(int time) {
        i = time;
    }

    public void run() {
        i++;
    }

    public int getTime() {
        return i;
    }

}