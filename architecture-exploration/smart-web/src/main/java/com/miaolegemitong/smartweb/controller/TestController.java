package com.miaolegemitong.smartweb.controller;

import com.miaolegemitong.smartframework.annotation.Action;
import com.miaolegemitong.smartframework.annotation.Controller;
import com.miaolegemitong.smartframework.annotation.Inject;
import com.miaolegemitong.smartframework.bean.Data;
import com.miaolegemitong.smartframework.bean.Param;
import com.miaolegemitong.smartframework.bean.View;
import com.miaolegemitong.smartweb.service.TestService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description
 */
@Controller
public class TestController {
    @Inject
    private TestService testService;

    @Action("get:/")
    public View testView(Param param) {
        return new View("hello.jsp");
    }

    @Action("get:/data")
    public Data testData(Param param) {
        Map<String, String> result = new HashMap<>();
        result.put("Hello", "World");
        return new Data(result);
    }

    @Action("get:/testTransaction")
    public Data testTransaction(Param param) {
        testService.testTransaction();
        Map<String, String> result = new HashMap<>();
        result.put("Hello", "World");
        return new Data(result);
    }
}
