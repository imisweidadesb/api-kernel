package com.zj.api.kernel.common.cache;

import java.io.Serializable;

/**
 * Created by js on 2017/1/17.
 */
public interface CacheService {

    <V extends Serializable> boolean set(String key, V value, Integer time);

    <V extends Serializable> V get(String key);

    boolean delete(String key);

}
