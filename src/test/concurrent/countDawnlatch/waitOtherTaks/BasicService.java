package test.concurrent.countDawnlatch.waitOtherTaks;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shibin on 2017/3/3.
 */
public class BasicService extends BaseHealthChecker {
    public BasicService(CountDownLatch countDownLatch) {
        super(countDownLatch, "basicService");
    }

    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}