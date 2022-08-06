package com.yjc;

import cn.hutool.core.io.IoUtil;
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
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        log.debug("file read success: \n" + content);
    }
}
