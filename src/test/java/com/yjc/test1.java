package com.yjc;

import com.yjc.bean.LiteAnnotationConfigApplicationContext;
import com.yjc.config.AppConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @author IntelliYJC
 * @create 2022/7/28 19:11
 */
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
}
