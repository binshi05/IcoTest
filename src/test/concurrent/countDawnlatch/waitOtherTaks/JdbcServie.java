package test.concurrent.countDawnlatch.waitOtherTaks;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shibin on 2017/3/3.
 */
public class JdbcServie extends BaseHealthChecker {
    public JdbcServie(CountDownLatch countDownLatch) {
        super(countDownLatch, "jdbcServie");
    }

    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}