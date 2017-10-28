package com.expedia.reflect.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author shareef on 27/10/2017
 * <p>
 * this class contains utilities for java reflection, reflection is reading the
 * class info and meta data in runtime
 */
public class Reflect {

    /**
     * check if the given class field is (final)
     *
     * @param field the class field to check
     * @return true if the class field is final
     */
    @SuppressWarnings("unchecked")
    public static boolean isFinal(Field field) {
        return field != null && Modifier.isFinal(field.getModifiers());
    }

    /**
     * check if the given class field is (static)
     *
     * @param field the class field to check
     * @return true if the class field is static
     */
    @SuppressWarnings("unchecked")
    public static boolean isStatic(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }
}
