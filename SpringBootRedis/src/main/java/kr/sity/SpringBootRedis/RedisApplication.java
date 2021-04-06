package kr.sity.SpringBootRedis;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisApplication implements ApplicationRunner {
	@Autowired
    StringRedisTemplate redisTemplate;
	/*@Autowired
    RedisTemplate redisTemplate;*/

	@Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("message", "hello world");
        
        System.out.println("Redis print= "+ new SimpleDateFormat("yyyyMMdd").format(new Date()).toString());
        System.out.println("Redis get message= "+ values.get("message"));
        
        
        InetAddress local = null;
        local = InetAddress.getLocalHost();
        String ip = local.getHostAddress();
        System.out.println("local ip : "+ip);
        

    }

}
