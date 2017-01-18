package com.zj.api.kernel.biz.daemon.mq.process.impl;

import com.zj.api.kernel.biz.daemon.mq.process.BaseMsgProcessor;
import com.zj.api.kernel.biz.daemon.service.StockMsgService;
import com.zj.api.model.stock.QuoteInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by js on 2017/1/18.
 */
@Service("stockMsgProcessor")
public class StockMsgProcessor implements BaseMsgProcessor {

    private static final Logger logger = LoggerFactory.getLogger(StockMsgProcessor.class);

    @Resource(name = "stockMsgService")
    private StockMsgService stockMsgService;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void process(final Serializable serializable) {
        if (serializable instanceof HashMap) {
            threadPoolTaskExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        logger.info("处理股票查询消息");
                        stockMsgService.saveStock((HashMap<String, QuoteInfo>) serializable);
                    } catch (Exception e) {
                        logger.error("处理股票查询消息失败,e:{}", e);
                    }
                }
            });
        }
    }
}
