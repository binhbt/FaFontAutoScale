package com.vn.fa.font;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * leobui 09/06/2018
 */
public class FontManager {
    public enum FontScaleType {
        SCALE_ALL,
        NOT_SCALE_ALL
    }

    volatile static FontManager instance;

    public static FontManager getDefault() {
        FontManager localRef = instance;
        if (localRef == null) {
            synchronized (FontManager.class) {
                localRef = instance;
                if (localRef == null) {
                    localRef = instance = new FontManager();
                }
            }
        }
        return localRef;
    }

    public Map<String, Float> getOriginItemSize() {
        return originItemSize;
    }

    public void setOriginItemSize(Map<String, Float> originItemSize) {
        this.originItemSize = originItemSize;
    }

    private Map<String, Float> originItemSize = new HashMap<>();
    private float scale = 1.0f;
    private FontScaleType scaleType = FontScaleType.NOT_SCALE_ALL;

    public FontScaleType getScaleType() {
        return scaleType;
    }

    public void setScaleType(FontScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    @Deprecated
    public static void bind(Object view) {

        Field[] fields = view.getClass().getFields();

        for (Field field : fields) {
            try {
                if (field.isAnnotationPresent(FontAutoScale.class)) {
                    FontAutoScale autoScale = field.getAnnotation(FontAutoScale.class);
                    boolean isScale = autoScale.isScale();
                    if (isScale && FontManager.getDefault().getScaleType() == FontScaleType.NOT_SCALE_ALL)
                        if (field.get(view) instanceof TextView) {
                            TextView textView = (TextView) field.get(view);
                            float originSize = textView.getTextSize();
                            if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
                                originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
                            } else {
                                FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
                            }
                            TextViewUtil.scaleUp(textView, originSize, FontManager.getDefault().getScale());
                        }
                    if (field.get(view) instanceof ViewGroup) {
                        View v = (View) field.get(view);
                        ViewGroupUtil.scaleUp(v, FontManager.getDefault().getScale());
                    }
                    if (field.get(view) instanceof WebView) {
                        WebView webView = (WebView) field.get(view);
                        WebViewUtil.scaleUp(webView, FontManager.getDefault().getScale());
                    }
                }
                if (field.isAnnotationPresent(FontIgnoreScale.class)) {
                    FontIgnoreScale fontIgnoreScale = field.getAnnotation(FontIgnoreScale.class);
                    if (FontManager.getDefault().getScaleType() == FontScaleType.SCALE_ALL)
                        if (field.get(view) instanceof TextView) {
                            TextView textView = (TextView) field.get(view);
                            float originSize = textView.getTextSize() / FontManager.getDefault().getScale();
                            if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
                                originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
                            } else {
                                FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
                            }
                            TextViewUtil.changeTextSize(textView, originSize);
                        }

                    if (field.get(view) instanceof ViewGroup) {
                        View v = (View) field.get(view);
                        ViewGroupUtil.scaleDown(v, FontManager.getDefault().getScale());
                    }
                    if (field.get(view) instanceof WebView) {
                        WebView webView = (WebView) field.get(view);
                        WebViewUtil.scaleDown(webView, FontManager.getDefault().getScale());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static float getOriginSize(TextView textView) {
        float originSize = textView.getTextSize();
        if (FontManager.getDefault().originItemSize.get(textView.hashCode() + "") != null) {
            originSize = FontManager.getDefault().originItemSize.get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().originItemSize.put(textView.hashCode() + "", originSize);
        }
        return originSize;
    }

    public static void adjustFontScaleAll(Context ctx, float scale) {
        Configuration configuration = ctx.getResources().getConfiguration();
        configuration.fontScale = scale;
        DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        ctx.getResources().updateConfiguration(configuration, metrics);
    }

    public static void applyScaleFont(View v) {
        if (FontManager.getDefault().getScaleType() != FontScaleType.NOT_SCALE_ALL) return;
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            if (textView != null) {
                float originSize = textView.getTextSize();
                if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
                    originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
                } else {
                    FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
                }
                TextViewUtil.scaleUp(textView, originSize, FontManager.getDefault().getScale());
            }
        }
        if (v instanceof ViewGroup) {
            ViewGroupUtil.scaleUp(v, FontManager.getDefault().getScale());
        }
        if (v instanceof WebView) {
            WebViewUtil.scaleUp((WebView) v, FontManager.getDefault().getScale());
        }
    }

    public static void applyScaleDownFont(View v) {

        if (FontManager.getDefault().getScaleType() != FontScaleType.SCALE_ALL) return;
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            if (textView != null) {
                float originSize = textView.getTextSize() / FontManager.getDefault().getScale();
                if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
                    originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
                } else {
                    FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
                }
                TextViewUtil.changeTextSize(textView, originSize);
            }
        }
        if (v instanceof ViewGroup) {
            ViewGroupUtil.scaleDown(v, FontManager.getDefault().getScale());
        }
        if (v instanceof WebView) {
            WebViewUtil.scaleDown((WebView) v, FontManager.getDefault().getScale());
        }
    }
}
