package Redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import redis.clients.jedis.Jedis;

public class RedisJava {
	//@Test
	void connectionTest() {
		Jedis jedis = new Jedis("127.0.0.1");
		
		jedis.set("runoobkey", "www.runoob.com");
		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
		
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		List<String> list = jedis.lrange("site-list", 0, 1);
		System.out.println(jedis.lindex("site-list", 0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println("列表项为: " + list.get(i));
		}

		// 获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}

	}
	
	@Test
	public  void testd() {
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis 存储的字符串为: " + jedis.get("ad_view"));
		jedis.close();
		
	}
	
	
	
	
}
