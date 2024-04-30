package com.apeframe.common.redis.util;


import com.apeframe.common.redis.exception.ShareLockException;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisShareLockUtil {

    @Resource
    private RedisUtil redisUtil;

    private static final long TIME_OUT = 10 * 1000L;

    public boolean lock(String lockKey, String requestId, Long time){
        // 1: 参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0){
            throw new ShareLockException("分布式加锁参数异常");
        }
        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        boolean result = false;
        // 2：加锁可以自旋
        while (currentTime < outTime){
            // 3：借助redis setNx来进行锁的设置
            result = redisUtil.setNX(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            if (result) return true;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime = System.currentTimeMillis();
        }


        return false;
    }

    public boolean unLock(String lockKey, String requestId){
        // 1: 参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId)){
            throw new ShareLockException("分布式加锁参数异常");
        }
        try {
            String value = redisUtil.getValToStr(lockKey);
            if (Objects.equals(value,requestId)){
                return redisUtil.delete(lockKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tryLock(String lockKey, String requestId, Long time){
        // 1: 参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0){
            throw new ShareLockException("分布式加锁参数异常");
        }

        return redisUtil.setNX(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }
}
