package com.zj.api.kernel.core.service.impl;

import com.zj.api.kernel.common.cache.CacheService;
import com.zj.api.kernel.core.facade.MemcachedFacade;
import com.zj.api.kernel.core.facade.result.Result;
import com.zj.api.kernel.core.facade.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by js on 2017/1/17.
 */
public class MemcachedFacadeImpl implements MemcachedFacade {

    private static final Logger logger = LoggerFactory.getLogger(MemcachedFacadeImpl.class);

    @Resource(name = "memcachedService")
    private CacheService cacheService;

    public <V extends Serializable> Result set(String key, V value, Integer time) {
        try {
            boolean success = cacheService.set(key, value, time);
            return ResultUtil.getSuccessResult(success);
        } catch (IllegalArgumentException e) {
            logger.error("api-kernel添加缓存内部错误,e:{}", e);
            return ResultUtil.getParamsErrorResult(e.getMessage());
        } catch (Exception e) {
            logger.error("api-kernel添加缓存失败,e:{}", e);
            return ResultUtil.getSystemErrorResult(e.getMessage());
        }
    }

    public <V extends Serializable> Result<V> get(String key) {
        try {
            boolean success = cacheService.get(key);
            return ResultUtil.getSuccessResult(success);
        } catch (IllegalArgumentException e) {
            logger.error("api-kernel获取缓存内部错误,e:{}", e);
            return ResultUtil.getParamsErrorResult(e.getMessage());
        } catch (Exception e) {
            logger.error("api-kernel获取缓存失败,e:{}", e);
            return ResultUtil.getSystemErrorResult(e.getMessage());
        }
    }


    public Result delete(String key) {
        try {
            boolean success = cacheService.delete(key);
            return ResultUtil.getSuccessResult(success);
        } catch (IllegalArgumentException e) {
            logger.error("api-kernel删除缓存内部错误,e:{}", e);
            return ResultUtil.getParamsErrorResult(e.getMessage());
        } catch (Exception e) {
            logger.error("api-kernel删除缓存失败,e:{}", e);
            return ResultUtil.getSystemErrorResult(e.getMessage());
        }
    }
}
