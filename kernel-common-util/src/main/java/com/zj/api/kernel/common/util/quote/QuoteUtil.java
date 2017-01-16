package com.zj.api.kernel.common.util.quote;

import com.zj.api.model.stock.QuoteInfo;

import java.util.Map;

/**
 * Created by js on 2017/1/16.
 */
public interface QuoteUtil {

    QuoteInfo getStockQuote(String stockCode);

    Map<String, QuoteInfo> getStocksQuote(String stockCodes);

}
