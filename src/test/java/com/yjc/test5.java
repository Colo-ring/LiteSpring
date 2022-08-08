package com.yjc;

import bean.UserService;
import com.yjc.litespringframework.context.support.ClassPathXmlApplicationContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author IntelliYJC
 * @create 2022/8/8 13:36
 */
@Slf4j(topic = "c.test5")
public class test5 {

    @Test
    public void t1() {
        // 1. 初始化 Beanfactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String res = userService.queryUserInfo();
        log.debug("测试结果：\n" + res);
    }
}
