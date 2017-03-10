package test.thread.java.lang.thread;

/**
 * Created by shibin on 2017/1/20.
 */
public class ThreadMain {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("AAA");
        MyThread myThread2 = new MyThread("BBB");
        myThread1.start();
        myThread2.start();

    }
}
