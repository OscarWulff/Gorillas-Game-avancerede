package ApplicationClasses;

import ApplicationClasses.*;
import Controllers.GameScreen;

import java.util.TimerTask;

//The variable 'i' holds how many seconds have gone since the game started.
public class TimeAdder extends TimerTask{
    int i;

    public TimeAdder(int time) {
        i = time;
    }

    public void run() {
        i++; //adds one "second" every time it is run
    }

    public int getTime() {
        return i;
    }

}