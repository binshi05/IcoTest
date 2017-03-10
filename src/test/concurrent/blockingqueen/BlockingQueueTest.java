package test.concurrent.blockingqueen;

import javax.swing.text.StyledEditorKit;
import java.util.concurrent.*;

/**
 * BlockingQueue是一种特殊的Queue，若BlockingQueue是空的，
 * 从BlockingQueue取东西的操作将会被阻断进入等待状态直到BlocingkQueue进了新货才会被唤醒。
 * 同样，如果BlockingQueue是满的任何试图往里存东西的操作也会被阻断进入等待状态，
 * 直到BlockingQueue里有新的空间才会被唤醒继续操作。
 * BlockingQueue提供的方法主要有：
 * add(anObject): 把anObject加到BlockingQueue里，如果BlockingQueue可以容纳返回true，否则抛出IllegalStateException异常。
 * offer(anObject)：把anObject加到BlockingQueue里，如果BlockingQueue可以容纳返回true，否则返回false。
 * put(anObject)：把anObject加到BlockingQueue里，如果BlockingQueue没有空间，调用此方法的线程被阻断直到BlockingQueue里有新的空间再继续。
 * poll(time)：取出BlockingQueue里排在首位的对象，若不能立即取出可等time参数规定的时间。取不到时返回null。
 * take()：取出BlockingQueue里排在首位的对象，若BlockingQueue为空，阻断进入等待状态直到BlockingQueue有新的对象被加入为止。
 * <p>
 * 根据不同的需要BlockingQueue有4种具体实现：
 * （1）ArrayBlockingQueue：规定大小的BlockingQueue，其构造函数必须带一个int参数来指明其大小。其所含的对象是以FIFO（先入先出）顺序排序的。
 * （2）LinkedBlockingQueue：大小不定的BlockingQueue，若其构造函数带一个规定大小的参数，生成的BlockingQueue有大小限制，
 * 若不带大小参数，所生成的BlockingQueue的大小由Integer.MAX_VALUE来决定。其所含的对象是以FIFO（先入先出）顺序排序的。
 * LinkedBlockingQueue和ArrayBlockingQueue比较起来，它们背后所用的数据结构不一样，
 * 导致LinkedBlockingQueue的数据吞吐量要大于ArrayBlockingQueue，但在线程数量很大时其性能的可预见性低于ArrayBlockingQueue。
 * （3）PriorityBlockingQueue：类似于LinkedBlockingQueue，但其所含对象的排序不是FIFO，而是依据对象的自然排序顺序或者是构造函数所带的Comparator决定的顺序。
 * （4）SynchronousQueue：特殊的BlockingQueue，对其的操作必须是放和取交替完成的。
 */
public class BlockingQueueTest {
    public static class Basket {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        public void product() throws InterruptedException {
            blockingQueue.put("An Apple");
        }
        public String consume() throws InterruptedException {
            return blockingQueue.take();
        }
    }

    public static void testBasket() {
        final Basket basket = new Basket();
        class Producer implements Runnable {
            public void run() {
                try {
                    while (true) {
                        //生产苹果
                        System.out.println("生产者准备生产苹果: " + System.currentTimeMillis());
                        basket.product();
                        System.out.println("生产者生产苹果完毕: " + System.currentTimeMillis());
                        //休眠300ms
                        Thread.sleep(300);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
        class Consumer implements Runnable {
            public void run() {
                    while (true) {
                        //消费苹果
                        System.out.println("消费者准备消费苹果: " + System.currentTimeMillis());
                        try {
                            basket.consume();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费者消费苹果完毕: " + System.currentTimeMillis());
                        //休眠300ms
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        executorService.submit(producer);
        executorService.submit(consumer);
        //程序运行5s后,所有任务停止
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
        }
//        executorService.shutdown();
        executorService.shutdownNow();
    }

    public static void main(String[] args) {
//        testBasket();
        BlockingQueueTest.testBasket();
    }
}
