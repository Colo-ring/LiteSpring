package com.yjc.entity;

import com.yjc.annotation.Autowired;
import com.yjc.annotation.Component;
import com.yjc.annotation.Value;
import lombok.Data;

@Data
@Component("myOrder")
public class Order {
    @Value("xxx123")
    private String orderId;
    @Value("1000.5")
    private Float price;
}
