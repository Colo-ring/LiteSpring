package com.yjc.litespringframework.beans;

/**
 * @author IntelliYJC
 * @create 2022/8/2 20:16
 * Bean 异常
 */

public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
