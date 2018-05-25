package com.xxd.quant.core.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by xuxiaodong on 18/5/25.
 */
public class HttpHelper {

    private static HttpClient httpClient;
    private static final  HttpHelper httpHelper= new HttpHelper();
    static {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(200);
        connManager.setDefaultMaxPerRoute(100);
        SocketConfig defaultSocketConfig = SocketConfig.custom().setSoTimeout(5000).build();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000).setConnectionRequestTimeout(500).setStaleConnectionCheckEnabled(true).build();
        connManager.setDefaultSocketConfig(defaultSocketConfig);
        httpClient = HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(requestConfig).build();
    }

    private HttpHelper() {

    }

    public static HttpHelper getInstance() {
        return httpHelper;
    }

    public String send(HttpGet httpGet) {
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            String content = EntityUtils.toString(entity);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
        }
        return null;
    }

}
