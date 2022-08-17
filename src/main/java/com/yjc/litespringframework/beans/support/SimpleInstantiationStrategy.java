package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 实例化对象
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor<?> ctor, Object... args) throws BeansException {
        Class<?> clazz = beanDefinition.getBeanClass();
        // 通过构造方法实例化对象
        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
