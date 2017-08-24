package com.miaolegemitong.smartframework.helper;

import com.miaolegemitong.smartframework.annotation.Controller;
import com.miaolegemitong.smartframework.annotation.Service;
import com.miaolegemitong.smartframework.utils.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/8/12
 * @description 类操作助手
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(Service.class)).collect(Collectors.toSet());
    }

    public static Set<Class<?>> getControllerClassSet() {
        return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(Controller.class)).collect(Collectors.toSet());
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        return CLASS_SET.stream().filter(cls -> superClass.isAssignableFrom(cls) && !superClass.equals(cls)).collect(Collectors.toSet());
    }

    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(annotationClass)).collect(Collectors.toSet());
    }
}
