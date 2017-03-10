package test.concurrent.executors.shareProperty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shibin on 2017/2/17.
 */
public class TestCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for(int t = 0 ;t < 20000; t++) {
            executorService.execute(new CommonPropertySafe.MyRun());
        }
        Thread.sleep(1000);
        System.out.println("公共i的值为" + CommonPropertySafe.i);
        executorService.shutdown();
    }
   /* public static void main1(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for(int t = 0 ;t < 5000; t++) {
            executorService.execute(new CommonPropertyNotSafe.MyRun());
        }
        Thread.sleep(1000);
        System.out.println("公共i的值为" + CommonPropertyNotSafe.i);
        executorService.shutdown();
    }*/

    /*public static void main2(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for(int t = 0 ;t < 10000; t++) {
            executorService.execute(new CommonPrrperty.MyRun());
//            Thread.sleep(2000);
//            System.out.println("*************" + t + "*************");
        }
        Thread.sleep(5000);
        System.out.println("公共i的值为" + CommonPrrperty.i);
        executorService.shutdown();
    }*/

}
