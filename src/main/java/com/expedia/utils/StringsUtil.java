package com.expedia.utils;

/**
 * @author shareef on 27/10/2017
 */
public class StringsUtil {

    /**
     * shortins the string used in exception
     * print so it will be shorter ( to save space and quota for other services)
     *
     * @param s
     * @param max
     * @return
     */
    public static String left(String s, int max) {
        return s.substring(0, Math.min(s.length(), max));
    }


    /**
     * convert the first character in the string to uppercase
     *
     * @param string this string to converts
     * @return the converted string
     */
    public static String capitalizeFirst(String string) {
        return Character.toString(string.charAt(0)).toUpperCase() + string.substring(1);
    }


}