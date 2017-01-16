package com.zj.api.kernel.biz.daemon.service;

/**
 * Created by js on 2017/1/16.
 */
public interface StockTaskService {

    /**
     * 接受消息并保存到数据库
     */
    void saveStock();
}
