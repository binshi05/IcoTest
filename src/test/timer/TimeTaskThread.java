package test.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by shibin on 2017/1/19.
 */
public class TimeTaskThread extends TimerTask    {

    public TimeTaskThread(){

    }

    @Override
    public void run() {
        System.out.println(new Date().toString() + "Timer方式，两秒执行一次！");
    }
}
