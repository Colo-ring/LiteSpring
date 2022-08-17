package com.yjc.entity;

import com.yjc.annotation.*;
import lombok.Data;

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
