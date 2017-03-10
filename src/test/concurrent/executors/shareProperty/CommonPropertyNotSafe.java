package test.concurrent.executors.shareProperty;


/**
 * Created by shibin on 2017/2/22.
 */
public class CommonPropertyNotSafe {
    public static int i = 0;

    static class MyRun implements Runnable {
        public void run() {
            System.out.println("线程" + i++ + ":" + Thread.currentThread().getName() + "正在执行");
        }
    }
}
