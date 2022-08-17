package com.yjc.litespringframework.beans.factory;

/**
 * 初始化接口
 */
public interface InitializingBean {
    /**
     * Bean处理属性填充后 调用该方法
     */
    void afterPropertiesSet() throws Exception;
}
