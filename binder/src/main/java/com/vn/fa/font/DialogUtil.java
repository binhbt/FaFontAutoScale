package com.vn.fa.font;

import android.view.View;

public final class DialogUtil {
    public static void scaleUp(android.app.Dialog dialog) {
        if (dialog != null){
            try {
                final View root = dialog.findViewById(android.R.id.content);
                ViewGroupUtil.scaleUp(root, FontManager.getDefault().getScale());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void scaleUp(android.app.Dialog dialog, float scale) {
        if (dialog != null){
            try {
                final View root = dialog.findViewById(android.R.id.content);
                ViewGroupUtil.scaleUp(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void scaleDown(android.app.Dialog dialog, float scale) {
        if (dialog != null){
            try {
                final View root = dialog.findViewById(android.R.id.content);
                ViewGroupUtil.scaleDown(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void scaleDown(android.app.Dialog dialog) {
        if (dialog != null){
            try {
                final View root = dialog.findViewById(android.R.id.content);
                ViewGroupUtil.scaleDown(root, FontManager.getDefault().getScale());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void scaleUp(android.app.Fragment fragment, float scale) {
        FragmentUtil.scaleUp(fragment, scale);
    }

    public static void scaleDown(android.app.Fragment fragment, float scale) {
        FragmentUtil.scaleDown(fragment, scale);
    }
    public static void scaleUp(android.support.v4.app.Fragment fragment, float scale) {
        FragmentUtil.scaleUp(fragment, scale);
    }

    public static void scaleDown(android.support.v4.app.Fragment fragment, float scale) {
        FragmentUtil.scaleDown(fragment, scale);
    }
}
