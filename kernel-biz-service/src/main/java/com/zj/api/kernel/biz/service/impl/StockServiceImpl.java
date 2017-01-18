package com.zj.api.kernel.biz.service.impl;


import com.zj.api.kernel.biz.service.StockService;
import com.zj.api.kernel.common.dao.BaseDAO;
import com.zj.api.kernel.common.dao.StockDAO;
import com.zj.api.kernel.common.util.mq.JmsProducer;
import com.zj.api.kernel.common.util.pattern.PatternUtil;
import com.zj.api.kernel.common.util.quote.QuoteUtil;
import com.zj.api.model.stock.QuoteInfo;
import com.zj.api.model.stock.Stock;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by js on 2017/1/17.
 */
@Service("stockService")
public class StockServiceImpl extends BaseServiceImpl<Stock> implements StockService {

    @Resource(name = "stockDAO")
    private StockDAO stockDAO;

    @Resource(name = "sinaQuotekUtil")
    private QuoteUtil quoteUtil;

    @Resource(name = "jmsProducer")
    private JmsProducer jmsProducer;

    protected BaseDAO<Stock> getDao() {
        return this.stockDAO;
    }

    public Map<String, QuoteInfo> getStockQuote(String stockCodes) {
        Assert.notNull(stockCodes, "股票代码不能为空");
        Assert.isTrue(PatternUtil.checkStr(stockCodes), "股票代码不合法");
        Map<String, QuoteInfo> resultMap = quoteUtil.getStocksQuote(stockCodes);
        //发送消息
        if (resultMap.size() > 0) {
            jmsProducer.sendMessage("QUEUE_QUERY_STOCK", (HashMap<String, QuoteInfo>) resultMap);
        }
        return resultMap;
    }


}
