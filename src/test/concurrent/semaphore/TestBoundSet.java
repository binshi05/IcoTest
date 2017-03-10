package test.concurrent.semaphore;

/**
 * Created by shibin on 2017/3/6.
 */
public class TestBoundSet {
    public static void main(String[] args) {
        BoundedHashSet<String> boundedHashSet = new BoundedHashSet(3);
        try {
            boolean aaa = boundedHashSet.add("aaa");
            System.out.println("aaa是否添加成功：" + aaa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            boolean bbb = boundedHashSet.add("bbb");
            System.out.println("bbb是否添加成功：" + bbb);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            boolean ccc = boundedHashSet.add("ccc");
            System.out.println("ccc是否添加成功：" + ccc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean aaa111 = boundedHashSet.remove("aaa");
        System.out.println("aaa111是否添加成功：" + aaa111);

        boolean bbb111 = boundedHashSet.remove("bbb");
        System.out.println("bbb111是否添加成功：" + bbb111);

        try {
            boolean ddd = boundedHashSet.add("ddd");
            System.out.println("ddd是否删除成功：" + ddd);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            boolean eee = boundedHashSet.add("eee");
            System.out.println("eee是否删除成功：" + eee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
