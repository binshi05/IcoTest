package test.redis;

import redis.clients.jedis.Jedis;

import static com.sun.webpane.platform.ConfigManager.log;

/**
 * Created by shibin on 2017/2/7.
 */
public class ResidTest {
    public static void main1(String[] args) {
        Jedis jedis = new Jedis("10.3.2.100");
        String key = "wusc";
        String value = "";

        jedis.del(key); // 删数据

        jedis.set(key, "WuShuicheng"); // 存数据
        value = jedis.get(key); // 取数据
//        log.info(key + "=" + value);
        System.out.println(key + "=" + value);

        jedis.set(key, "WuShuicheng2"); // 存数据
        value = jedis.get(key); // 取数据
//        log.info(key + "=" + value);
        System.out.println(key + "=" + value);

        //jedis.del(key); // 删数据
        //value = jedis.get(key); // 取数据
        //log.info(key + "=" + value);
    }
    public static void main (String[] args) {
        Jedis jedis = new Jedis("10.3.2.100");
        String key = "wusc";
        String value = "";
        value = jedis.get(key); // 取数据
        System.out.println(key + "=" + value);

    }
}
