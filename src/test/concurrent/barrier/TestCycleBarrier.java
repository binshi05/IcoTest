package test.concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by shibin on 2017/3/6.
 * 主线程中新建了5个线程，所有的这些线程都调用cb.await()等待。
 * 所有这些线程一直等待，直到cb中所有线程都达到barrier时，这些线程才继续运行
 */
public class TestCycleBarrier {
    private static final int SIZE = 5;
    private static  CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(SIZE, new Runnable() {
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cyclicBarrier.getParties());
            }
        });
        for(int i = 0 ;i < 5 ;i++) {
            new InnerThread().start();
        }

    }

    static class InnerThread extends Thread {
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
                // 将cb的参与者数量加1
                cyclicBarrier.await();
                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch( BrokenBarrierException e) {
                e.printStackTrace();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
