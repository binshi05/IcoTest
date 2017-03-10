package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by shibin on 2017/2/9.
 */
public class HashTest {
    public static void main1(String[] args) throws UnsupportedEncodingException {
        byte[] a1 = {'s','s'};
        byte[] b1 = {'s','s'};
        String a = new String(a1, "UTF-8");
        String b = new String(b1, "GBK");
        System.out.println(a.hashCode() == b.hashCode()); //true
    }

    public static void main(String[] args) {
        String str = "abc你好";
        System.out.println(str.hashCode());
        System.out.println(Charset.defaultCharset()); //UTF-8

    }
}
