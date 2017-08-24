package com.miaolegemitong.smartweb.service;

import com.miaolegemitong.smartframework.annotation.Service;
import com.miaolegemitong.smartframework.annotation.Transaction;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/23
 * @description
 */
@Service
public class TestService {
    @Transaction
    public void testTransaction() {

    }
}
