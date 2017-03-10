package test.concurrent.executors.shareProperty;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shibin on 2017/2/17.
 * 使用Lock实现线程安全
 */
public class CommonPrrperty {
    public static int i = 0;
    static Lock lock = new ReentrantLock();

    static class MyRun implements Runnable {
        public void run() {
            lock.lock();
            System.out.println("线程" + i++ + ":" + Thread.currentThread().getName() + "正在执行");
            lock.unlock();
        }
    }
}
