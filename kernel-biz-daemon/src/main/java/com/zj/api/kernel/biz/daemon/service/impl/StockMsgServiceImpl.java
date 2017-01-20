package com.zj.api.kernel.biz.daemon.service.impl;

import com.zj.api.common.util.pinyin.Pinyin4jUtil;
import com.zj.api.kernel.biz.daemon.service.StockMsgService;
import com.zj.api.kernel.common.cache.CacheService;
import com.zj.api.kernel.common.dao.StockDAO;
import com.zj.api.kernel.common.dao.query.StockQuery;
import com.zj.api.model.constant.CacheKeyConstant;
import com.zj.api.model.stock.QuoteInfo;
import com.zj.api.model.stock.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
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


    @Transactional
    public void saveStock(HashMap<String, QuoteInfo> quoteInfoHashMap) {
        if (!quoteInfoHashMap.isEmpty()) {
            StockQuery stockQuery;
            Set<String> keys = quoteInfoHashMap.keySet();
            for (String str : keys) {
                QuoteInfo quoteInfo = quoteInfoHashMap.get(str);
                if (quoteInfo != null && StringUtils.hasText(quoteInfo.getStockName())) {
                    cacheService.set(CacheKeyConstant.QUOTE_INFO_KEY + quoteInfo.getStockCode(), quoteInfo, 0);
                    stockQuery = new StockQuery();
                    stockQuery.setStockCode(quoteInfo.getStockCode());
                    if (stockDAO.getByStockCode(quoteInfo.getStockCode()) == null) {
                        addStock(quoteInfo);
                    }
                }
            }
        }
    }

    private void addStock(QuoteInfo quoteInfo) {
        Stock stock = new Stock();
        stock.setStockCode(quoteInfo.getStockCode());
        stock.setStockName(quoteInfo.getStockName());
        stock.setSimpleName(Pinyin4jUtil.converterToFirstSpell(quoteInfo.getStockName()));
        stock.setCreateTime(new Date());
        stockDAO.insert(stock);
    }
}
