package com.zj.api.kernel.common.dao.impl;

import com.zj.api.kernel.common.dao.StockDAO;
import com.zj.api.model.stock.Stock;
import org.springframework.stereotype.Repository;

/**
 * Created by js on 2017/1/16.
 */
@Repository("stockDAO")
public class StockDAOImpl extends BaseDAOImpl<Stock> implements StockDAO {

}
