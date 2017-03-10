package test.concurrent.blockingqueen;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by shibin on 2017/2/16.
 * 阻塞队列初始化为3，如果超过3时，将阻塞
 */
public class BasicProperty {
    static BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
    public static void main(String[] args) throws InterruptedException {
        blockingQueue.put("aaa");
        blockingQueue.put("bbb");
        blockingQueue.put("ccc");
        System.out.println(blockingQueue.take());
        Thread.sleep(2000);
        blockingQueue.put("ddd");
        Thread.sleep(2000);
        System.out.println(blockingQueue.take());
        Thread.sleep(2000);
        System.out.println(blockingQueue.take());
        Thread.sleep(2000);
        System.out.println(blockingQueue.take());
    }
}
