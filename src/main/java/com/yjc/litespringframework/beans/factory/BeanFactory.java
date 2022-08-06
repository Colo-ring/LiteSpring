package com.yjc.litespringframework.beans.factory;

import com.yjc.litespringframework.beans.BeansException;

/**
 * @author IntelliYJC
 * @create 2022/8/1 18:23
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
