package com.yjc.processor;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.PropertyValue;
import com.yjc.litespringframework.beans.PropertyValues;
import com.yjc.litespringframework.beans.factory.BeanDefinition;
import com.yjc.litespringframework.beans.factory.ConfigurableListableBeanFactory;
import com.yjc.litespringframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
