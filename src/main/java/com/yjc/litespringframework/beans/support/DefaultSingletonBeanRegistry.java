package com.yjc.litespringframework.beans.support;

import com.yjc.litespringframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/8/2 20:09
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        // TODO: 三级缓存
        return singletonObjects.get(name);
    }

    protected void addSingleton(String name, Object singletonObject) {
        // TODO: 三级缓存
        singletonObjects.put(name, singletonObject);
    }
}
