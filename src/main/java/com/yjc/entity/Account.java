package com.yjc.entity;

import com.yjc.annotation.*;
import lombok.Data;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:03
 */

@Data
@Repository
public class Account {
    @Value("1")
    private Integer id;
    @Value("张三")
    private String name;
    @Value("22")
    private Integer age;
    @Autowired
    //@Qualifier("myOrder")
    private Order order;
}
