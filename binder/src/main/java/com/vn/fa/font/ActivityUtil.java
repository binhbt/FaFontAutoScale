package com.vn.fa.font;

import android.app.Activity;
import android.view.View;

public final class ActivityUtil {
    public static void scaleUp(Activity activity, float scale) {
        if (activity != null){
            try {
                View root = activity.getWindow().getDecorView();
//                final ViewGroup root = (ViewGroup) ((ViewGroup) activity
//                        .findViewById(android.R.id.content)).getChildAt(0);
                ViewGroupUtil.scaleUp(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void scaleDown(Activity activity, float scale) {
        if (activity != null){
            try {
                View root = activity.getWindow().getDecorView();
//                final ViewGroup root = (ViewGroup) ((ViewGroup) activity
//                        .findViewById(android.R.id.content)).getChildAt(0);
                ViewGroupUtil.scaleDown(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
