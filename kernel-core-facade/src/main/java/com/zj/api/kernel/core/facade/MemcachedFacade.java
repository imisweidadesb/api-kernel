package com.zj.api.kernel.core.facade;

import com.zj.api.kernel.core.facade.result.Result;

import java.io.Serializable;

/**
 * Created by js on 2017/1/17.
 */
public interface MemcachedFacade {

    <V extends Serializable> Result set(String key, V value, Integer time);

    <V extends Serializable> Result<V> get(String key);

    Result delete(String key);

}
