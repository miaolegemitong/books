package com.miaolegemitong.smartframework.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 数组工具类
 */
public class ArrayUtil {
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
