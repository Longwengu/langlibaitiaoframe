package com.apeframe.common.redis.util;

import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public boolean setNX(String key, Object value, Long time, TimeUnit timeUnit){
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, timeUnit);
    }

    public boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public String getValToStr(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean isExist(String key){
        return redisTemplate.hasKey(key).booleanValue();
    }








}
