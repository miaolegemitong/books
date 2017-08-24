package com.miaolegemitong.smartframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/22
 * @description 数据库工具类
 */
public class DBUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtil.class);

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<>();

    public static Connection getConnection(String driver, String url, String username, String password) {
        Connection conn = connContainer.get();
        try {
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            LOGGER.error("get db connection failure", e);
        } finally {
            connContainer.set(conn);
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = connContainer.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            LOGGER.error("close db connection failure", e);
        } finally {
            connContainer.remove();
        }
    }
}
