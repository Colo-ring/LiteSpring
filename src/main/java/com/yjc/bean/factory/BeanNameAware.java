package com.yjc.bean.factory;

/**
 * @author IntelliYJC
 * @create 2022/7/30 15:31
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}

