package ApplicationClasses;

import ApplicationClasses.*;
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