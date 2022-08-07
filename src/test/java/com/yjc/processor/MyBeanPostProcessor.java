package com.yjc.processor;

import bean.UserService;
import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.config.BeanPostProcessor;

/**
 * @author IntelliYJC
 * @create 2022/8/7 14:37
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
