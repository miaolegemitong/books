package com.miaolegemitong.smartframework.helper;

import com.miaolegemitong.smartframework.ConfigConstant;
import com.miaolegemitong.smartframework.utils.PropsUtil;

import java.util.Properties;

import static com.miaolegemitong.smartframework.ConfigConstant.*;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 属性文件助手
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, JDBC_DRIVER);
    }

    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, JDBC_URL);
    }

    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS, JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, JDBC_PASSWORD);
    }

    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, APP_BASE_PACKAGE);
    }

    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, APP_JSP_PATH, "/WEB-INF/view/");
    }

    public static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, APP_ASSET_PATH, "/asset/");
    }
}
