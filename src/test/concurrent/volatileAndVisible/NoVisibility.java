package test.concurrent.volatileAndVisible;

/**
 * Created by shibin on 2017/2/22.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    static class MyThread extends Thread{
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        number = 10;
        ready = true;
    }
}
