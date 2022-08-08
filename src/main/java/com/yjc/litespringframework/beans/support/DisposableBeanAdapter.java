package com.yjc.litespringframework.beans.support;

import cn.hutool.core.util.StrUtil;
import com.yjc.litespringframework.beans.BeansException;
import com.yjc.litespringframework.beans.factory.BeanDefinition;
import com.yjc.litespringframework.beans.factory.DisposableBean;

import java.lang.reflect.Method;

/**
 * @author IntelliYJC
 * @create 2022/8/8 12:37
 * 销毁方法适配器，提供两种方式：实现接口 DisposableBean、配置信息 destroy-method
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method
        if (StrUtil.isNotEmpty(destroyMethodName) &&
                !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            // 避免二次执行销毁
            if (destroyMethod == null) {
                throw new BeansException("Couldn't find a destroy method named '" +
                        destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
