package test.join;
/**
 * Created by shibin on 2017/1/20.
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 t.join();      //使调用线程 t 在此之前执行完毕。
 t.join(1000);  //等待 t 线程，等待时间是1000毫秒
 */
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "主线程开始");
        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        System.out.println(Thread.currentThread().getName() + "主线程结束");
    }
}
