package com.zj.api.kernel.biz.daemon.service;

import com.zj.api.model.stock.QuoteInfo;

import java.util.HashMap;

/**
 * Created by js on 2017/1/16.
 */
public interface StockMsgService {

    /**
     * 接受消息并保存到数据库
     */
    void saveStock(HashMap<String, QuoteInfo> quoteInfoHashMap);
}
