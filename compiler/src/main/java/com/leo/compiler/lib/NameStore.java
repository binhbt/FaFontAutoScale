package com.leo.compiler.lib;

import com.leo.lib.annotations.internal.BindingSuffix;

public final class NameStore {

    private NameStore() {
        // not to be instantiated in public
    }

    public static String getGeneratedClassName(String clsName) {
        return clsName + BindingSuffix.GENERATED_CLASS_SUFFIX;
    }

    public static class Package {
        public static final String FONT_MANAGER  = "com.vn.fa.font";
    }

    public static class Class {
        // Android
        public static final String FONT_MANAGER = "FontManager";

    }

    public static class Method {
        // Binder
        public static final String BIND_FONTS = "bindFonts";
        public static final String BIND = "bind";

        public static final String APPLY_SCALE_FONT ="applyScaleFont";
    }

    public static class Variable {
        public static final String CONTAINER = "container";
    }
}

