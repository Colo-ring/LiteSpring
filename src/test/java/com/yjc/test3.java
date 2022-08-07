package com.yjc;

import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.yjc.litespringframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yjc.litespringframework.beans.support.DefaultListableBeanFactory;
import com.yjc.litespringframework.core.io.DefaultResourceLoader;
import com.yjc.litespringframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author IntelliYJC
 * @create 2022/8/6 15:33
 */

@Slf4j(topic = "c.test3")
public class test3 {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test // 测试classpath
    public void t1() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        log.debug("classpath read success: \n" + content);
    }

    @Test // 测试文件读取
    public void t2() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        log.debug("file read success: \n" + content);
    }

    @Test // 测试url读取
    public void t3() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/Colo-ring/LiteSpring/blob/master/src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        log.debug("URL read success: \n" + content);
    }

    @Test // 测试bean注册
    public void t4() throws IOException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.读取配置文件 & 注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3.获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String res = userService.queryUserInfo();
        log.debug("测试结果: \n" + res);
    }
}
