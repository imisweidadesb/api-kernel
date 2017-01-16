package com.zj.api.kernel.common.util.quote.impl;

import com.zj.api.kernel.common.util.quote.QuoteUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by js on 2017/1/16.
 */
@Service("stockUtil")
public class QuoteUtilImpl implements QuoteUtil {

    private final static Logger logger = LoggerFactory.getLogger(QuoteUtilImpl.class);

    @Value("${sinaQuoteUrl}")
    private String sinaQuoteUrl;

    private HttpClient httpClient;

    public QuoteUtilImpl() {
        this.httpClient = HttpClients.createDefault();
    }

    public void getStockQuote(String stockCode) {
        HttpGet httpGet = new HttpGet(sinaQuoteUrl.replace("stockCode", stockCode));
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity, "UTF-8");
        } catch (IOException e) {
            logger.error("获取行情失败,e:{}", e);
        }
    }

}
