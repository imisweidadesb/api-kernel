package com.zj.api.kernel.biz.daemon.mq.process.impl;

import com.zj.api.kernel.biz.daemon.mq.process.BaseMsgProcessor;
import com.zj.api.kernel.biz.daemon.service.StockMsgService;
import com.zj.api.model.stock.QuoteInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by js on 2017/1/18.
 */
@Service("stockMsgProcessor")
public class StockMsgProcessor implements BaseMsgProcessor {

    @Resource(name = "stockMsgService")
    private StockMsgService stockMsgService;

    public void process(Serializable serializable) {
        if (serializable instanceof HashMap) {
            stockMsgService.saveStock((HashMap<String, QuoteInfo>) serializable);
        }
    }
}
