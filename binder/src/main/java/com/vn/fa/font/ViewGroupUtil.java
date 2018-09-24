package com.vn.fa.font;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.vn.fa.font.TextViewUtil;

/**
 * leobui 09/17/2018
 */
public final class ViewGroupUtil {
    public static void scaleUp(View v, float scale) {
        try {
            if (v instanceof WebView) {
                WebViewUtil.scaleUp((WebView) v, scale);
            } else if (v instanceof TextView) {
                TextViewUtil.scaleUp((TextView) v, scale);
            } else if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    scaleUp(child, scale);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scaleDown(View v, float scale) {
        try {
            if (v instanceof WebView) {
                WebViewUtil.scaleDown((WebView) v, scale);
            } else if (v instanceof TextView) {
                TextViewUtil.scaleDown((TextView) v, scale);
            } else if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    scaleDown(child, scale);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
