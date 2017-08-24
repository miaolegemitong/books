package com.miaolegemitong.smartframework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/22
 * @description 切面代理
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethd();
        Object[] params = proxyChain.getMethodParams();



        return result;
    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
    }

    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {
    }

    public void end() {
    }
}
