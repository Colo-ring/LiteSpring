package com.yjc.litespringframework.beans.factory.config;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author IntelliYJC
 * @create 2022/8/7 12:50
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
