package com.zj.api.kernel.core.facade;

import com.zj.api.kernel.core.facade.result.Result;

/**
 * Created by js on 2017/1/17.
 */
public interface QuoteFacade {

    Result queryStockQuote(String stockCodes);
}
