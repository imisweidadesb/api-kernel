package com.zj.api.kernel.common.cache.impl;


import com.zj.api.kernel.common.cache.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZJ on 2016/12/21.
 */

@Service("localCacheService")
public class LocalCacheServiceImpl implements CacheService, InitializingBean {

    private class LocalCacheDTO implements Serializable {

        private static final long serialVersionUID = -6390841196053709785L;

        private Object value;

        /**
         * 缓存到期时间
         */
        private Date expireTime;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Date getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Date expireTime) {
            this.expireTime = expireTime;
        }

        @Override
        public String toString() {
            return "LocalCacheDTO{" +
                    "value=" + value +
                    ", expireTime=" + expireTime +
                    '}';
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(LocalCacheServiceImpl.class);

    /**
     * 本地缓存最长过期时间为30天
     */
    private final Integer maxExpireTime = 30 * 24 * 60 * 60 * 1000;

    private ConcurrentHashMap cacheMap;

    private ExecutorService executorService;

    public LocalCacheServiceImpl() {
        this.cacheMap = new ConcurrentHashMap();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void afterPropertiesSet() throws Exception {
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Set<String> set = cacheMap.keySet();
                        Iterator<String> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            String next = iterator.next();
                            LocalCacheDTO dto = (LocalCacheDTO) cacheMap.get(next);
                            //当前时间大于到期时间时移除缓存
                            if (dto.getExpireTime().compareTo(new Date()) <= 0) {
                                cacheMap.remove(next);
                            }
                        }
                        Thread.sleep(1 * 1000);
                    }
                } catch (Exception e) {
                    logger.error("本地缓存过期移除失败,e:{}", e);
                }
            }
        });
    }

    public <V extends Serializable> boolean set(String key, V value, Integer time) {
        if (null == key || null == value) {
            logger.error("key或者value为空");
            return false;
        }
        try {
            LocalCacheDTO dto = new LocalCacheDTO();
            dto.setValue(value);
            dto.setExpireTime(time == 0 ? new Date(System.currentTimeMillis() + maxExpireTime) : new Date(System.currentTimeMillis() + time * 1000));
            cacheMap.put(key, dto);
            return true;
        } catch (Exception e) {
            logger.error("添加本地缓存失败,e:{}", e);
            return false;
        }

    }

    public <V extends Serializable> V get(String key) {
        if (null == key) {
            logger.error("key不能空");
            return null;
        }
        try {
            LocalCacheDTO dto = (LocalCacheDTO) cacheMap.get(key);
            return dto == null ? null : (V) dto.getValue();
        } catch (Exception e) {
            logger.error("查询本地缓存失败,e:{}", e);
        }
        return null;
    }

    public boolean delete(String key) {
        if (null == key) {
            logger.error("key不能空");
            return false;
        }
        try {
            cacheMap.remove(key);
            return true;
        } catch (Exception e) {
            logger.error("删除本地缓存失败,e:{}", e);
            return false;
        }

    }
}
