package com.xxd.quant.core.http;

import com.xxd.quant.core.data.DataUrl;
import org.apache.http.client.methods.HttpGet;

/**
 * Created by xuxiaodong on 18/5/25.
 */
public class HttpUtil {

    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet(new DataUrl("sh601003,sh601001").getRealUrl());
        System.out.println(HttpHelper.getInstance().send(httpGet));


    }
}
