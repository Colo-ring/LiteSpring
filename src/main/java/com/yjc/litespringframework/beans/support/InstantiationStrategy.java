package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author IntelliYJC
 * @create 2022/8/3 13:39
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String name, Constructor<?> ctor, Object... args) throws BeansException;
}
