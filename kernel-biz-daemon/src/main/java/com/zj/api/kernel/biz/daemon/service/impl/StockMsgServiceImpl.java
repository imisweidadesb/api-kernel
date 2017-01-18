package com.zj.api.kernel.biz.daemon.service.impl;

import com.zj.api.kernel.biz.daemon.service.StockMsgService;
import com.zj.api.kernel.common.cache.CacheService;
import com.zj.api.kernel.common.dao.StockDAO;
import com.zj.api.kernel.common.dao.query.StockQuery;
import com.zj.api.model.stock.QuoteInfo;
import com.zj.api.model.stock.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by js on 2017/1/16.
 */
@Service("stockMsgService")
public class StockMsgServiceImpl implements StockMsgService {

    private static final Logger logger = LoggerFactory.getLogger(StockMsgServiceImpl.class);

    @Resource(name = "stockDAO")
    private StockDAO stockDAO;

    @Resource(name = "memcachedService")
    private CacheService cacheService;

    private final String QUOTE_INFO_KEY = "QUOTE_INFO_KEY_";


    @Transactional
    public void saveStock(HashMap<String, QuoteInfo> quoteInfoHashMap) {
        if (!quoteInfoHashMap.isEmpty()) {
            StockQuery stockQuery;
            Set<String> keys = quoteInfoHashMap.keySet();
            for (String str : keys) {
                QuoteInfo quoteInfo = quoteInfoHashMap.get(str);
                if (quoteInfo != null) {
                    cacheService.set(QUOTE_INFO_KEY + quoteInfo.getStockCode(), quoteInfo, 0);
                    stockQuery = new StockQuery();
                    stockQuery.setStockCode(quoteInfo.getStockCode());
                    List<Stock> stocks = stockDAO.getByQuery(stockQuery);
                    addStock(quoteInfo, stocks);
                }
            }
        }
    }

    private void addStock(QuoteInfo quoteInfo, List<Stock> stocks) {
        if (stocks == null && stocks.isEmpty()) {
            Stock stock = new Stock();
            stock.setStockCode(quoteInfo.getStockCode());
            stock.setStockName(quoteInfo.getStockName());
            stock.setCreateTime(new Date());
            stockDAO.insert(stock);
        }
    }
}
