package com.zj.api.kernel.biz.service;

import com.zj.api.model.stock.QuoteInfo;
import com.zj.api.model.stock.Stock;

import java.util.Map;

/**
 * Created by js on 2017/1/17.
 */
public interface StockService extends BaseService<Stock> {

    Map<String, QuoteInfo> getStockQuote(String stockCodes);

}
