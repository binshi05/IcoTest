package test.concurrent.executors.shareProperty;


import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shibin on 2017/2/22.
 * 使用原子操作类AtomicLong实现线程安全
 */
public class CommonPropertySafe {
    public static AtomicLong i = new AtomicLong(0);

    static class MyRun implements Runnable {
        public void run() {
            System.out.println("线程" + i.incrementAndGet() + ":" + Thread.currentThread().getName() + "正在执行");
        }
    }
}
