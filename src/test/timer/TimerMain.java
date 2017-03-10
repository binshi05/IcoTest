package test.timer;

import java.util.Date;
import java.util.Timer;

/**
 * Created by shibin on 2017/1/19.
 */
public class TimerMain {


    public static void main(String[] args) {
        Timer timer = new Timer();
//    timer.schedule(new TimeTaskThread(), new Date(), 2000);
        timer.schedule(new TimeTaskThread(),1000,5000);
    }

}
