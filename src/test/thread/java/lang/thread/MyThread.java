package test.thread.java.lang.thread;

/**
 * Created by shibin on 2017/1/20.
 */
public class MyThread  extends Thread{
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    public void run(){
        for(int i = 0; i < 5 ;i++){
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
