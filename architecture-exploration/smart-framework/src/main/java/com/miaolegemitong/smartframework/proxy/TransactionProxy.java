package com.miaolegemitong.smartframework.proxy;

import com.miaolegemitong.smartframework.annotation.Transaction;
import com.miaolegemitong.smartframework.helper.DataBaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/23
 * @description 事务代理
 */
public class TransactionProxy implements Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethd();
        if (!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                DataBaseHelper.beginTransaction();
                System.out.println("begin transaction");
                LOGGER.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DataBaseHelper.commitTransaction();
                LOGGER.debug("commit transaction");
            } catch (Exception e) {
                DataBaseHelper.rollbackTransaction();
                LOGGER.debug("rollback transaction");
                throw e;
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
