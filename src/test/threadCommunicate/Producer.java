package test.threadCommunicate;

/**
 * Created by shibin on 2017/2/8.
 * 类描述：生产者－消费者模型之生产者
 */
public class Producer extends Thread {
    private int needNum;//每次要生产产品的数量
    private Godown godown;//仓库
    public Producer(int needNum,Godown godown){
        this.needNum = needNum;
        this.godown = godown;
    }
    /**
     * 重写 java.lang.Thread 的 run 方法
     */
    public void run(){
        godown.product(needNum);
    }
}
