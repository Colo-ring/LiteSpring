package com.yjc.litespringframework.beans.factory;

import com.yjc.litespringframework.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型 返回 Bean 实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    // TODO: 三级缓存
    // <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
