package com.miaolegemitong.smartframework.bean;

import com.miaolegemitong.smartframework.utils.CastUtil;

import java.util.Map;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 请求参数
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public int getInt(String name) {
        return CastUtil.castInt(paramMap.get(name));
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public double getDouble(String name) {
        return CastUtil.castDouble(paramMap.get(name));
    }

    public String getString(String name) {
        return CastUtil.castString(paramMap.get(name));
    }

    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(paramMap.get(name));
    }
}
