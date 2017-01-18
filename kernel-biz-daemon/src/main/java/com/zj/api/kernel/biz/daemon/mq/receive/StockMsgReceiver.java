package com.zj.api.kernel.biz.daemon.mq.receive;

import com.zj.api.kernel.biz.daemon.mq.listener.ConsumerListener;
import com.zj.api.kernel.biz.daemon.mq.process.impl.StockMsgProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by js on 2017/1/18.
 */
@Component("stockMsgReceiver")
public class StockMsgReceiver implements ConsumerListener {

    @Resource(name = "stockMsgProcessor")
    private StockMsgProcessor stockMessageProcessor;

    public void receiveMessage(Serializable serializable) {
        stockMessageProcessor.process(serializable);
    }
}
