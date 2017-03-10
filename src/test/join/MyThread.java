package test.join;

/**
 * Created by shibin on 2017/1/20.
 */
public class MyThread extends Thread {
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程运行开始");
        for(int i = 0 ; i < 5 ;i++){
            System.out.println(name + "线程开始运行" + i);
            try {
                sleep((int)Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}
