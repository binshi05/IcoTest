package test.threadCommunicate;

/**
 * Created by shibin on 2017/2/8.
 */
public class Consumer extends Thread {
    private int needNum;//消费的数量
    private Godown godown;//仓库

    public Consumer(int needNum, Godown godown) {
        this.needNum = needNum;
        this.godown = godown;
    }
    /**
     * 重写 java.lang.Thread 的 run 方法
     */
    public void run(){
        godown.consume(needNum);
    }
}
