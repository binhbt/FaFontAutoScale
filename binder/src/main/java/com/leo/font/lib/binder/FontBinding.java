package com.leo.font.lib.binder;

import com.leo.font.lib.annotations.internal.BindingSuffix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * Created by @leobui 09/19/2018
 */
public class FontBinding {

    private FontBinding() {
        // not to be instantiated in public
    }

    private static <T> void instantiateBinder(T target, String suffix) {
        Class<?> targetClass = target.getClass();
        String className = targetClass.getName();
        try {
            Class<?> bindingClass = targetClass
                    .getClassLoader()
                    .loadClass(className + suffix);
            Constructor<?> classConstructor = bindingClass.getConstructor(targetClass);
            try {
                classConstructor.newInstance(target);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to invoke " + classConstructor, e);
            } catch (InstantiationException e) {
                throw new RuntimeException("Unable to invoke " + classConstructor, e);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                }
                if (cause instanceof Error) {
                    throw (Error) cause;
                }
                throw new RuntimeException("Unable to create instance.", cause);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find Class for " + className + suffix, e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to find constructor for " + className + suffix, e);
        }
    }

    public static <T> void bind(T container) {
        instantiateBinder(container, BindingSuffix.GENERATED_CLASS_SUFFIX);
    }
}
