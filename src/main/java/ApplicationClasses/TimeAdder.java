package ApplicationClasses;

import ApplicationClasses.*;
import Controllers.GameScreen;

import java.util.TimerTask;


public class TimeAdder extends TimerTask{
    int i = 0;

    public void run() {
        i++;
    }

    public int getTime() {
        return i;
    }

}