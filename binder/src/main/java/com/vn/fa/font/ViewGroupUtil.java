package com.vn.fa.font;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * leobui 09/17/2018
 */
public class ViewGroupUtil {
    public static void scaleUp(View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    scaleUp(child);
                }
            } else if (v instanceof TextView) {
                TextViewUtil.scaleUp((TextView) v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void scaleDown(View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    scaleDown(child);
                }
            } else if (v instanceof TextView) {
                TextViewUtil.scaleDown((TextView) v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
