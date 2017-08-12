package com.miaolegemitong.smartframework.helper;

import com.miaolegemitong.smartframework.annotation.Inject;
import com.miaolegemitong.smartframework.utils.ArrayUtil;
import com.miaolegemitong.smartframework.utils.CollectionUtil;
import com.miaolegemitong.smartframework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 依赖注入
 */
public class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
