package com.xxd.quant.core.data;

/**
 * Created by xuxiaodong on 18/5/25.
 */
public class DataUrl {
    private static final String realUrl = "http://hq.sinajs.cn/list=";
    private static final String histroyUrl = "";

    private String param;

    private String requestRealUrl;

    private String requestHistoryUrl;

    public DataUrl(String stockCode) {
        param = stockCode;
    }

    public String getHistroyUrl() {
        return histroyUrl.concat(param);
    }
    public String getRealUrl() {
        return realUrl.concat(param);
    }
}
