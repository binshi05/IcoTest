package test.refact;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shibin on 2017/3/4.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> myList=new ArrayList<Integer>(10);
        System.out.println(myList.size());
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(4);
        System.out.println(myList.size());
        myList.add(6);
        myList.add(5);
        Class c=myList.getClass();
        Field f;
        try {
            f=c.getDeclaredField("elementData");
            f.setAccessible(true);
            Object[] o=(Object[])f.get(myList);
            System.out.println(o.length);
        } catch (NoSuchFieldException   e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
