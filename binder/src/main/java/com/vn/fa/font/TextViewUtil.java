package com.vn.fa.font;

import android.util.TypedValue;
import android.widget.TextView;

/**
 * leobui 09/06/2018
 */
public class TextViewUtil {
    public static void scaleUp(TextView textView, float originSize, float scale){
        changeTextSize(textView, originSize * scale);
    }
    public static void changeTextSize(TextView textView, float size){
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public static void scaleUp(TextView textView){
        float originSize = textView.getTextSize();
        if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
            originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
        }
        changeTextSize(textView, originSize * FontManager.getDefault().getScale());
    }
    public static void scaleDown(TextView textView){
        float originSize = textView.getTextSize() / FontManager.getDefault().getScale();
        if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
            originSize = FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
        }
        TextViewUtil.changeTextSize(textView, originSize);
    }
}
