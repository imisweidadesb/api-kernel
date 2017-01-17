package com.zj.api.kernel.common.util.http;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ZJ on 2017/1/16.
 */
public class HttpRequest {

    private static HttpURLConnection httpURLConnection;

    private static URL url;

    public static String doGet(String httpUrl) throws IOException {
        StringBuffer result = new StringBuffer();
        InputStream inputStream;
        BufferedReader reader;

        url = new URL(httpUrl);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
        inputStream = httpURLConnection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
        String str;
        while ((str = reader.readLine()) != null) {
            result.append(str);
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(reader);
        httpURLConnection.disconnect();
        return result.toString();
    }
}
