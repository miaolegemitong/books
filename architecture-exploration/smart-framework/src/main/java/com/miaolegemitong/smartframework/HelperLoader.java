package com.miaolegemitong.smartframework;

import com.miaolegemitong.smartframework.helper.BeanHelper;
import com.miaolegemitong.smartframework.helper.ClassHelper;
import com.miaolegemitong.smartframework.helper.ControllerHelper;
import com.miaolegemitong.smartframework.helper.IocHelper;
import com.miaolegemitong.smartframework.utils.ClassUtil;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description
 */
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
