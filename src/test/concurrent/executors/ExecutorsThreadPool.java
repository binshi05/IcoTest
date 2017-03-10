package test.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shibin on 2017/2/9.
 * Java线程：线程池
 * http://zy116494718.iteye.com/blog/1704344
 * http://zy116494718.iteye.com/blog/1725365
 */
public class ExecutorsThreadPool {
    private static int i = 0;
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
//        Thread myThread1 = new MyThread();
//        Thread myThread2 = new MyThread();
//        Thread myThread3 = new MyThread();
        Thread myThread4 = new MyThread();
        Thread myThread5 = new MyThread();
        //将线程放入池中进行执行
//        executorService.execute(myThread1);
//        executorService.execute(myThread2);
//        executorService.execute(myThread3);
        executorService.execute(myThread4);
        executorService.execute(myThread5);
        //关闭线程池
        executorService.shutdown();
    }
    static class MyThread extends Thread{
        public void run(){
            System.out.println(Thread.currentThread().getName() + "正在运行.." + "i的值为" + i++);
        }
    }
}
