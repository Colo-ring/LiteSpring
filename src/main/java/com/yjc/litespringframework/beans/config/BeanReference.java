package com.yjc.litespringframework.beans.config;

/**
 * @author IntelliYJC
 * @create 2022/8/4 13:41
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
