package com.vn.fa.font;

import android.util.Log;
import android.webkit.WebView;

/**
 * leobui 09/17/2018
 */
public final class WebViewUtil {
    public static void scaleUp(WebView webView, float scale){
        //Log.e("Scale Webview", webView.toString()+"-"+scale);
        changeTextSize(webView, (int)(scale*100));
    }
    public static void changeTextSize(WebView webView, int scale){
        webView.getSettings().setTextZoom(scale);
    }
    public static void scaleDown(WebView webView, float scale){
        changeTextSize(webView, (int)(100/scale));
    }
}
