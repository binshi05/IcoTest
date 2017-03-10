package test.concurrent.countDawnlatch.waitOtherTaks;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shibin on 2017/3/3.
 */
public abstract class BaseHealthChecker implements Runnable{
    private  CountDownLatch countDownLatch ;
    private String serviceName;

    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }

    public void run() {
        try {
            verifyService();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    public abstract void verifyService();

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
