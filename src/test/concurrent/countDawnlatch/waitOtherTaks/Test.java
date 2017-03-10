package test.concurrent.countDawnlatch.waitOtherTaks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by shibin on 2017/3/3.
 * 在这个例子中，我模拟了一个应用程序启动类，它开始时启动了n个线程类，
 * 这些线程将检查外部系统并通知闭锁，并且启动类一直在闭锁上等待着。
 * 一旦验证和检查了所有外部服务，那么启动类恢复执行。
 *
 * 假如服务A需要在B/C/D三个服务启动会才能启动
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Executor executor = Executors.newFixedThreadPool(3);
        List<BaseHealthChecker> list = new ArrayList<BaseHealthChecker>();
        list.add(new NetWorkService(countDownLatch));
        list.add(new BasicService(countDownLatch));
        list.add(new JdbcServie(countDownLatch));
        System.out.println("主任务开始！！");
        for (BaseHealthChecker baseHealthChecker : list) {
            executor.execute(baseHealthChecker);
        }
        countDownLatch.await();
        System.out.println("主任务结束！！");
    }
}
