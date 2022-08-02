package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.factory.BeanDefinition;

/**
 * @author IntelliYJC
 * @create 2022/8/2 20:21
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
