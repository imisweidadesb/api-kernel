package com.zj.api.kernel.common.dao;

import com.zj.api.model.stock.Stock;

import java.util.List;

/**
 * Created by js on 2017/1/16.
 */
public interface StockDAO extends BaseDAO<Stock> {

    Stock getByStockCode(String stockCodes);
}
