package redis;

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
		// 鑾峰彇瀛樺偍鐨勬暟鎹苟杈撳嚭
		System.out.println("redis 瀛樺偍鐨勫瓧绗︿覆涓�: " + jedis.get("runoobkey"));
		
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		List<String> list = jedis.lrange("site-list", 0, 1);
		System.out.println(jedis.lindex("site-list", 0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println("鍒楄〃椤逛负: " + list.get(i));
		}

		// 鑾峰彇鏁版嵁骞惰緭鍑�
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
		System.out.println("redis 瀛樺偍鐨勫瓧绗︿覆涓�: " + jedis.get("ad_view"));
		jedis.close();
		
	}
	
	
	
	
}
