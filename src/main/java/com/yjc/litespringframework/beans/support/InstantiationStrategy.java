package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String name, Constructor<?> ctor, Object... args) throws BeansException;
}
