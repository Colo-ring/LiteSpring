package com.yjc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:31
 */

@Data
@AllArgsConstructor
public class BeanDefinition {
    private String beanName;
    private Class<?> beanClass;
}
