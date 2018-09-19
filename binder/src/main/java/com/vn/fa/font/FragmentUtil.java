package com.vn.fa.font;

import android.view.View;

public final class FragmentUtil {
    public static void scaleUp(android.app.Fragment fragment, float scale) {
        if (fragment != null && fragment.isAdded()){
            try {
                final View root = fragment.getView();
                ViewGroupUtil.scaleUp(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void scaleDown(android.app.Fragment fragment, float scale) {
        if (fragment != null && fragment.isAdded()){
            try {
                final View root = fragment.getView();
                ViewGroupUtil.scaleDown(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void scaleUp(android.support.v4.app.Fragment fragment, float scale) {
        if (fragment != null && fragment.isAdded()){
            try {
                final View root = fragment.getView();
                ViewGroupUtil.scaleUp(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void scaleDown(android.support.v4.app.Fragment fragment, float scale) {
        if (fragment != null && fragment.isAdded()){
            try {
                final View root = fragment.getView();
                ViewGroupUtil.scaleDown(root, scale);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
