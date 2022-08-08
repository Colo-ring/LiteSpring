package com.yjc.litespringframework.context;

import com.yjc.litespringframework.beans.BeansException;

/**
 * @author IntelliYJC
 * @create 2022/8/6 16:38
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
