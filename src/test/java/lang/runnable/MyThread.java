package test.java.lang.runnable;

/**
 * Created by shibin on 2017/1/20.
 */
public class MyThread implements Runnable {
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
