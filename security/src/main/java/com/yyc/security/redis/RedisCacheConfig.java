package com.yyc.security.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @Auther: yangyongcui
 * @Date: 2018/7/17: 10:22
 * @Description:
 */
@Configuration
public class RedisCacheConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        ObjectRedisSerializer objectRedisSerializer = new ObjectRedisSerializer();
        redisTemplate.setValueSerializer(objectRedisSerializer);
        return redisTemplate;
    }
}
