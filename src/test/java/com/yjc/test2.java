package com.yjc;

import bean.UserDao;
import bean.UserService;
import com.yjc.litespringframework.beans.PropertyValue;
import com.yjc.litespringframework.beans.PropertyValues;
import com.yjc.litespringframework.beans.factory.config.BeanReference;
import com.yjc.litespringframework.beans.factory.BeanDefinition;
import com.yjc.litespringframework.beans.support.DefaultListableBeanFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.test2")
public class test2 {
    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, null);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "张三");

        userService.queryUserInfo();
    }

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();


    }
}
