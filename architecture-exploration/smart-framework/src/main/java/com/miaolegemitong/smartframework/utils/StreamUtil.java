package com.miaolegemitong.smartframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 流操作
 */
public class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            LOGGER.error("get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
