package com.yjc.litespringframework.beans.factory;


import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.config.AutowireCapableBeanFactory;
import com.yjc.litespringframework.beans.factory.config.BeanPostProcessor;
import com.yjc.litespringframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
