package test;

/**
 * Created by shibin on 2017/2/22.
 */
public class TempTest {
    public static void test1(){
        StringBuffer stringBuffer;
        String str = "";
        for (int i = 1 ;i <= 5 ;i++) {
            stringBuffer = new StringBuffer();
            str += stringBuffer.append(i);
            System.out.println(str);
        }
    }
    public static void test2(){
        String str = "";
        for (int i = 1 ;i <= 5 ;i++) {
            StringBuffer stringBuffer = new StringBuffer();
            str += stringBuffer.append(i);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
