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
}
