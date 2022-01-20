package ApplicationClasses;

import java.util.TimerTask;

//The variable 'i' holds how many seconds have gone since the game started.
public class TimeAdder extends TimerTask{
    private int time;

    public TimeAdder(int time) {
        this.time = time;
    }

    public void run() {
        time++; //adds one "second" every time it is run
    }

    public int getTime() {
        return time;
    }
}