package com.apeframe.user.cache;


import com.apeframe.common.redis.init.AbstractCache;
import com.apeframe.common.redis.util.RedisUtil;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class SysUserCache extends AbstractCache {

    private static final String SYS_USER_CACHE_KEY = "SYS_USER";
    @Resource
    private RedisUtil redisUtil;

    @Override
    public void initCache() {
       redisUtil.set("age", 22);
    }


    @Override
    public <T> T getCache(String key) {
        boolean exist = redisUtil.isExist(key);
        if (!exist){
            this.reloadCache();
        }
        return (T) redisUtil.get(key);
    }


    @Override
    public void clearCache() {
        redisUtil.delete(SYS_USER_CACHE_KEY);
    }


}
