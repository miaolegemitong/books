package com.miaolegemitong.smartframework.proxy;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/22
 * @description 代理接口
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
