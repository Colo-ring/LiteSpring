package com.yjc.litespringframework.context.support;

import com.yjc.litespringframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yjc.litespringframework.beans.support.DefaultListableBeanFactory;

/**
 * @author IntelliYJC
 * @create 2022/8/7 13:57
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    // 从入口上下文类，拿到配置信息的地址描述
    protected abstract String[] getConfigLocations();
}
