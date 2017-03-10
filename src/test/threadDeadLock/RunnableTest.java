package test.threadDeadLock;

import wsdl.ObjectFactory;

/**
 * Created by shibin on 2017/2/8.
 * 死锁是因为多线程访问共享资源，由于访问的顺序不当所造成的，通常是一个线程锁定了一个资源A，
 * 而又想去锁定资源B；在另一个线程中，锁定了资源B，而又想去锁定资源A以完成自身的操作，
 * 两个线程都想得到对方的资源，而不愿释放自己的资源，造成两个线程都在等待，而无法执行的情况;

 产生死锁的条件：
1.有至少一个资源不能共享
2.至少有一个任务必须持有一个资源并且等待获取另一个被别的任务持有的资源
3.资源不能任务抢占
4.必须有循环等待
只要打破其中一个条件就不会产生死锁，通常是打破第4个条件
 */
public class RunnableTest implements Runnable {
    private int flag = 1;
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 0) {
            synchronized (obj1) {
                System.out.println("我已经锁定obj1，休息0.5秒后锁定obj2去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 1) {
            synchronized (obj2) {
                System.out.println("我已经锁定obj2，休息0.5秒后锁定obj1去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest1 = new RunnableTest();
        RunnableTest runnableTest2 = new RunnableTest();
        runnableTest1.setFlag(0);
        runnableTest2.setFlag(1);
        Thread thread1 = new Thread(runnableTest1);
        Thread thread2 = new Thread(runnableTest2);
        thread1.start();
        thread2.start();
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public static Object getObj1() {
        return obj1;
    }

    public static void setObj1(Object obj1) {
        RunnableTest.obj1 = obj1;
    }

    public static Object getObj2() {
        return obj2;
    }

    public static void setObj2(Object obj2) {
        RunnableTest.obj2 = obj2;
    }
}
