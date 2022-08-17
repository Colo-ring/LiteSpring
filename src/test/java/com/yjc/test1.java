package com.yjc;

import com.yjc.bean.LiteAnnotationConfigApplicationContext;
import com.yjc.config.AppConfig;
import com.yjc.litespringframework.beans.factory.BeanDefinition;
import com.yjc.litespringframework.beans.support.DefaultListableBeanFactory;
import com.yjc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.test1")
public class test1 {
    public static void main(String[] args) {
        LiteAnnotationConfigApplicationContext applicationContext = new LiteAnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBeanDefinitionCount());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
            System.out.println(applicationContext.getBean(beanDefinitionName));
        }
    }

    @Test
    public void test2() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

}
