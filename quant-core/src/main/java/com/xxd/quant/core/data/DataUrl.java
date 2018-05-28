package com.xxd.quant.core.data;

/**
 * Created by xuxiaodong on 18/5/25.
 */
public class DataUrl {
    private static final String realUrl = "http://hq.sinajs.cn/list=";
    private static final String histroyUrl = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData";

    private String param;

    private String requestRealUrl;

    private String requestHistoryUrl;

    public DataUrl(String stockCode) {
        param = stockCode;
    }

    public DataUrl(String stockCode,String scale,String ma,String datalen) {
        param = "?symbol=".concat(stockCode).concat("&scale=").concat(scale).concat("&ma=").concat(ma).concat("&datalen=").concat(datalen);
    }

    public String getHistroyUrl() {
        return histroyUrl.concat(param);
    }
    public String getRealUrl() {
        return realUrl.concat(param);
    }
}
