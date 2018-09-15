package com.androiddeft.recyclerviewdemo.font;

import android.content.Context;
import android.content.SharedPreferences;

import com.vn.fa.font.FontManager;


/**
 * Created by leobui on 09/08/2018
 */
public class FontHelper {
    public static final String PREF_NAME = "FONT_SCALE";
    public static final String FONT_TYPE = "FONT_TYPE";

    public static final float SMALL_SCALE = 1.0f;
    public static final float BIG_SCALE = 1.5f;
    public static final float HUGE_SCALE = 2.0f;

    public static void init(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(
                PREF_NAME, Context.MODE_PRIVATE);
        int type = prefs.getInt(FONT_TYPE, 0);
        if (type == 0) {
            FontManager.getDefault().setScale(SMALL_SCALE);
        }
        if (type == 1) {
            FontManager.getDefault().setScale(BIG_SCALE);
        }
        if (type == 2) {
            FontManager.getDefault().setScale(HUGE_SCALE);
        }
    }
    public static void init(Context ctx, FontManager.FontScaleType scaleType) {
        FontManager.getDefault().setScaleType(scaleType);
        if (scaleType == FontManager.FontScaleType.SCALE_ALL){
            FontManager.adjustFontScaleAll(ctx, FontManager.getDefault().getScale());
        }
        init(ctx);
    }
    public static void scaleFont(Context ctx, int type) {
        if (type == 0) {
            FontManager.getDefault().setScale(SMALL_SCALE);
        }
        if (type == 1) {
            FontManager.getDefault().setScale(BIG_SCALE);
        }
        if (type == 2) {
            FontManager.getDefault().setScale(HUGE_SCALE);
        }
        SharedPreferences prefs = ctx.getSharedPreferences(
                PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt(FONT_TYPE, type).apply();
    }
}
