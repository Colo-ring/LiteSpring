package com.yjc.service;

import com.yjc.annotation.Autowired;
import com.yjc.annotation.Component;
import com.yjc.bean.factory.BeanNameAware;
import lombok.Data;

/**
 * @author IntelliYJC
 * @create 2022/7/30 15:32
 */
@Data
@Component
public class UserService implements BeanNameAware {
    @Autowired
    private OrderService orderService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    // 测试
    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }
}
