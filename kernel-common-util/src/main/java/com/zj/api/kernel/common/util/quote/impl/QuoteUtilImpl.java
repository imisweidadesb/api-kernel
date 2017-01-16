package com.zj.api.kernel.common.util.quote.impl;

import com.zj.api.kernel.common.util.quote.QuoteUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by js on 2017/1/16.
 */
@Service("stockUtil")
public class QuoteUtilImpl implements QuoteUtil {

    private final static Logger logger = LoggerFactory.getLogger(QuoteUtilImpl.class);

    @Value("${sinaQuoteUrl}")
    private String sinaQuoteUrl;

    private HttpURLConnection httpURLConnection;

    private URL url;

    public void getStockQuote(String stockCode) {
        InputStream inputStream = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            url = new URL(sinaQuoteUrl.replace("stockCode", stockCode));
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            String str;
            while ((str = reader.readLine()) != null) {
                result.append(str);
            }
        } catch (IOException e) {
            logger.error("获取行情失败,e:{}", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(reader);
            httpURLConnection.disconnect();
        }
    }

}
