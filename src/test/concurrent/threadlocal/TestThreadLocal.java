package test.concurrent.threadlocal;

/**
 * Created by shibin on 2017/2/24.
 * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供
 * 独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本
 * 从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        //重新ThreadLocal的初始化方法，直接返回0
        @Override
        public Integer initialValue(){
            return 0;
        }
    };

    public Integer getNextNum() {
        num.set(num.get() + 1);
        return num.get();
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    static class MyThread extends Thread {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        public void run(){
            for(int i = 0 ;i < 3 ;i++) {
                System.out.println("线程：" + Thread.currentThread().getName() + "num的值为：" + testThreadLocal.getNextNum());
            }
        }
    }
}
