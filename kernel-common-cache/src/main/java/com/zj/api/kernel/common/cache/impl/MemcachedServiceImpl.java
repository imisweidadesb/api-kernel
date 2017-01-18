package com.zj.api.kernel.common.cache.impl;

import com.whalin.MemCached.MemCachedClient;
import com.zj.api.kernel.common.cache.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by js on 2016/12/27.
 */
@Service("memcachedService")
public class MemcachedServiceImpl implements CacheService {

    private final static Logger logger = LoggerFactory.getLogger(MemcachedServiceImpl.class);

    @Resource(name = "memcachedClient")
    private MemCachedClient memcachedClient;

    public <V extends Serializable> boolean set(String key, V value, Integer time) {
        if (null == key || null == value) {
            logger.error("key或者value为空");
            return false;
        }
        try {
            if (time == 0) {
                return memcachedClient.set(key, value, time);
            }
            return memcachedClient.set(key, value, new Date(1000 * time));
        } catch (Exception e) {
            logger.error("添加memcached缓存失败,e:{}", e);
        }
        return false;
    }

    public <V extends Serializable> V get(String key) {
        if (null == key) {
            logger.error("key不能空");
            return null;
        }
        try {
            return (V) memcachedClient.get(key);
        } catch (Exception e) {
            logger.error("查询memcached缓存失败,e:{}", e);
        }
        return null;
    }

    public boolean delete(String key) {
        if (null == key) {
            logger.error("key不能空");
            return false;
        }
        try {
            return memcachedClient.delete(key);
        } catch (Exception e) {
            logger.error("删除memcached缓存失败,e:{}", e);
        }
        return false;
    }
}
