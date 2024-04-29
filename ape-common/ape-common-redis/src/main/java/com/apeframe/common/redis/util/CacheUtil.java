package com.apeframe.common.redis.util;


import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
@Slf4j
public class CacheUtil<K, V> {
    /**
     * 是否开启本地缓存
     */
    @Value("${caffeine.cache.switch}")
    public Boolean switchCache;

    private final Cache<String, String> localCache =  Caffeine.newBuilder()
            .maximumSize(5000).expireAfterWrite(3, TimeUnit.SECONDS)
            .build();

    /**
     *
     * @param list 要处理的数据
     * @param cachePrefix 缓存键值
     * @param clazz 要转换的类型
     * @param function 处理的方法
     * @return
     */
    public Map<K, V> getResult(List<K> list, String cachePrefix, Class<V> clazz,
                               Function<List<K>, Map<K, V>> function){

        Map<K, V> resultMap = null;
        if (list.isEmpty()) return resultMap;
        // 声明一个结果
        resultMap = new HashMap<>(16);
        if (!switchCache){
            resultMap = function.apply(list);
            return resultMap;
        }
        // 本地缓存没有的
        List<K> noCacheList = new ArrayList<>();
        for (K k : list) {
            String key = cachePrefix + "_" + k;
            // 从缓存里面取
            String content = localCache.getIfPresent(key);
            if (!StringUtils.isBlank(content)) {
                V v = JSON.parseObject(content, clazz);
                resultMap.put(k, v);
            } else {
                noCacheList.add(k);
            }
        }

        if (noCacheList.isEmpty()) return resultMap;

        Map<K, V> noCacheResult = function.apply(noCacheList);
        if (noCacheResult == null || noCacheResult.isEmpty())  return resultMap;
        for (Map.Entry<K, V> entry : noCacheResult.entrySet()) {
            K key = entry.getKey();
            V result = entry.getValue();
            resultMap.put(key,result);
        }
        return resultMap;

    }
}
