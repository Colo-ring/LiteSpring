package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.BeanDefinition;
import com.yjc.litespringframework.beans.factory.BeanFactory;

/**
 * @author IntelliYJC
 * @create 2022/8/2 20:03
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    // 模板模式 ====
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    // 创建 bean
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
    // ============
}
