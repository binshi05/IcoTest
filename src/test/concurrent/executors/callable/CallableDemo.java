package test.concurrent.executors.callable;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by shibin on 2017/2/17.
 * 在Java 5之后，任务分两类：一类是实现了Runnable接口的类，一类是实现了Callable接口的类。
 * 两者都可以被ExecutorService执行，但是Runnable任务没有返回值，而Callable任务有返回值。
 * 并且Callable的call()方法只能通过ExecutorService的submit(Callable task) 方法来执行，
 * 并且返回一个 Future，是表示任务等待完成的 Future。
 * Future提供了三种功能：
 　　1）判断任务是否完成；
 　　2）能够中断任务；
 　　3）能够获取任务执行结果。
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int j = 0; j <= 10; j++) {
            Future<String> future = executorService.submit(new TaskWithResult(j));
            list.add(future);
        }
        for (Future future : list) {
            while (!future.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
            //对比while (!future.isDone())
            System.out.println(future.get());
        }
        executorService.shutdown();
    }

    static class TaskWithResult implements Callable<String> {
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        /**
         * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
         * 则该方法自动在一个线程上执行
         */
        public String call() throws Exception {
//            System.out.println("call()方法被自动调用！！！" + Thread.currentThread().getName());
            //该返回结果将被Future的get方法得到
            return "call()方法被自动调用，任务返回的结果是：" + id + "  " + Thread.currentThread().getName();
        }
    }
}
