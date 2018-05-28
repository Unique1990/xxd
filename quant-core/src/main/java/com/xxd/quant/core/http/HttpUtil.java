package com.xxd.quant.core.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xxd.quant.core.data.DataUrl;
import com.xxd.quant.core.data.HistoryData;
import org.apache.http.client.methods.HttpGet;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuxiaodong on 18/5/25.
 */
public class HttpUtil {

    private static final Gson gson  = new Gson();

    private static Type type = new TypeToken<ArrayList<HistoryData>>() {

    }.getType();

    public static void main(String[] args) {
        String url = new DataUrl("sh601003","5", "5", "210").getHistroyUrl();
        System.out.printf(url);
        HttpGet httpGet = new HttpGet(url);
        String result = HttpHelper.getInstance().send(httpGet);
        System.out.println(result);
        List<HistoryData> historyDatasList = gson.fromJson(result, type);
        return;


    }
}
