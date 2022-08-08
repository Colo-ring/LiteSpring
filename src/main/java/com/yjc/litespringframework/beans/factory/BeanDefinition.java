package com.yjc.litespringframework.beans.factory;

import com.yjc.litespringframework.beans.PropertyValues;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:31
 */

public class BeanDefinition {
    private Class<?> beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    /*public BeanDefinition() {
        this.propertyValues = new PropertyValues();
    }*/

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues pvs) {
        this.beanClass = beanClass;
        this.propertyValues = pvs != null ? pvs : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
