package com.yjc.litespringframework.beans.config;

/**
 * @author IntelliYJC
 * @create 2022/8/2 20:07
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String name);
}
