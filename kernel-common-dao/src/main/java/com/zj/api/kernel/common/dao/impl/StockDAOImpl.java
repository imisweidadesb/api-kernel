package com.zj.api.kernel.common.dao.impl;

import com.zj.api.kernel.common.dao.StockDAO;
import com.zj.api.model.stock.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


/**
 * Created by js on 2017/1/16.
 */
@Repository("stockDAO")
public class StockDAOImpl extends BaseDAOImpl<Stock> implements StockDAO {

    public Stock getByStockCode(String stockCode) {
        Assert.notNull(stockCode, "股票代码不能为空");
        return getSqlSession().selectOne(nameSpace + "SELECT_BY_STOCK_CODE", stockCode);
    }
}
