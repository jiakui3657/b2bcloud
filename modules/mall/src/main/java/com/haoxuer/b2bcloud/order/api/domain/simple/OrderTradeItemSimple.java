package com.haoxuer.b2bcloud.order.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderTradeItemSimple implements Serializable {

    private Long id;

    //购买数量
    private Integer size;

    //使用数量
    private Integer useNum;

    //价格锁定
    private BigDecimal price;

    //商品名称
    private String name;

    //商品图片
    private String logo;

}
