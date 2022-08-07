package com.yjc;

import bean.UserService;
import com.yjc.litespringframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yjc.litespringframework.beans.support.DefaultListableBeanFactory;
import com.yjc.litespringframework.context.support.ClassPathXmlApplicationContext;
import com.yjc.processor.MyBeanFactoryPostProcessor;
import com.yjc.processor.MyBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author IntelliYJC
 * @create 2022/8/7 14:32
 */
@Slf4j(topic = "c.test4")
public class test4 {

    @Test //测试---不应用上下文
    public void t1() {
        // 1. 初始化 beanfactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件 & 注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & 实例化之前，修改 Bean Definition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean 实例化之后，修改 Bean 信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取 Bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String res = userService.queryUserInfo();
        log.debug("t1测试结果：\n" + res);
    }

    @Test //测试---应用上下文
    public void t2() {
        // 1. 初始化 beanfactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String res = userService.queryUserInfo();
        log.debug("t2测试结果：\n" + res);
    }
}
