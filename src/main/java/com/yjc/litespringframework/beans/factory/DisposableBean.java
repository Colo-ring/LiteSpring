package com.yjc.litespringframework.beans.factory;

/**
 * 销毁接口
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
