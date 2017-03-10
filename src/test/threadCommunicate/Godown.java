package test.threadCommunicate;

/**
 * Created by shibin on 2017/2/7.
 * 测试线程间的通信
 * 规则：
 1、仓满不能生产；
 2、藏空不能消费；
 3、消费者消费产品前发现不能满足此次消费后通知生产者进行生产；
 4、生产者生产出产品后通知消费者进行消费。
 * 类描述：生产者－消费者模型之仓库
 */
public class Godown {
    private static int max_size = 100; //仓库最大容量
    private int curNum; //当前数量
    public Godown(int curNum){
        this.curNum = curNum;
    }

    /**
     * 生产商品
     * @param needNum 需要生产的数量
     */
    public synchronized void  product(int needNum){
        //生产的数量比最大容量大
        while(this.curNum + needNum > max_size){
            System.out.println(Thread.currentThread().getName() + "要生产的产品数量" + needNum +
                    "已经超出剩余库存容量" + (this.max_size - this.curNum) +"，暂时不能进行生产任务！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.curNum += needNum;
        System.out.println(Thread.currentThread().getName() + "已经生产了" +
                needNum + "，现存库存量是为：" + this.curNum);
        /**
         * 唤醒在此对象监视器上等待的所有线程
         */
        notifyAll();
    }

    /**
     *  消费商品
      * @param needNum
     */
    public synchronized void consume(int needNum){
        //消费的数量大于当前数量，给出提示并等待
        while(this.curNum < needNum){
            System.out.println(Thread.currentThread().getName() + "要消费的产品数量" +
                    needNum + "已经超出剩余库存量" + this.curNum + "，暂时不能进行消费！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.curNum -= needNum;
        System.out.println(Thread.currentThread().getName() + "已经消费了" + needNum + "，现存库存量是为：" + this.curNum);
        notifyAll();
    }
}

