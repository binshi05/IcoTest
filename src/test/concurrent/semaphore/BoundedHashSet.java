package test.concurrent.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by shibin on 2017/3/6.
 * 使用Semaphore可以将任意一种容器变成有界容器
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;
    public BoundedHashSet(int bound) {
        set = Collections.synchronizedSet(new HashSet<T>());
        semaphore = new Semaphore(bound);
    }

    public boolean add(T object) throws InterruptedException {
        semaphore.acquire();
        boolean result = set.add(object);
        if(!result){
            semaphore.release();
        }
        return result;
    }

    public boolean remove(T o) {
        boolean wasRemoved = set.remove(o);
        if(wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

}
