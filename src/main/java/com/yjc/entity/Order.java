package com.yjc.entity;

import com.yjc.annotation.Component;
import com.yjc.annotation.Value;
import lombok.Data;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:04
 */

@Data
@Component("myOrder")
public class Order {
    @Value("xxx123")
    private String orderId;
    @Value("1000.5")
    private Float price;
}
