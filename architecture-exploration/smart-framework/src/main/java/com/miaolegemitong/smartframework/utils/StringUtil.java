package com.miaolegemitong.smartframework.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 字符串工具
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] splitString(String str, String separator) {
        return str.split(separator, -1);
    }
}
