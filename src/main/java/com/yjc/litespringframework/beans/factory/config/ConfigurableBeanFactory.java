package com.yjc.litespringframework.beans.factory.config;

import com.yjc.litespringframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author IntelliYJC
 * @create 2022/8/6 16:47
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    // 销毁单例对象
    void destroySingletons();

}
