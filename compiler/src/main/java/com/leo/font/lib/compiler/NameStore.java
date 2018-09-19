package com.leo.font.lib.compiler;

import com.leo.font.lib.annotations.internal.BindingSuffix;

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
        public static final String BIND_FONTS = "bindFonts";
    }

    public static class Variable {
        public static final String CONTAINER = "container";
    }
}

