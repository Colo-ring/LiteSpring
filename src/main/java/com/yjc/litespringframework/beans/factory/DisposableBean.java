package com.yjc.litespringframework.beans.factory;

/**
 * @author IntelliYJC
 * @create 2022/8/8 12:02
 * 销毁接口
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
