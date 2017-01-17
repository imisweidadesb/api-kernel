package com.zj.api.kernel.core.service.impl;

import com.zj.api.kernel.biz.service.StockService;
import com.zj.api.kernel.core.facade.QuoteFacade;
import com.zj.api.kernel.core.facade.result.Result;
import com.zj.api.kernel.core.facade.util.ResultUtil;
import com.zj.api.model.stock.QuoteInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by js on 2017/1/17.
 */
public class QuoteFacadeImpl implements QuoteFacade {

    private static final Logger logger = LoggerFactory.getLogger(QuoteFacadeImpl.class);

    @Resource(name = "stockService")
    private StockService stockService;

    public Result queryStockQuote(String stockCodes) {
        try {
            Map<String, QuoteInfo> resultData = stockService.getStockQuote(stockCodes);
            return ResultUtil.getSuccessResult(resultData);
        } catch (IllegalArgumentException e) {
            logger.error("api-kernel获取行情内部错误,e:{}", e);
            return ResultUtil.getParamsErrorResult(e.getMessage());
        } catch (Exception e) {
            logger.error("api-kernel获取行情失败,e:{}", e);
            return ResultUtil.getSystemErrorResult(e.getMessage());
        }
    }
}
