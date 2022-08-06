package com.yjc.litespringframework.beans;

/**
 * @author IntelliYJC
 * @create 2022/8/4 13:04
 * 属性值类
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
