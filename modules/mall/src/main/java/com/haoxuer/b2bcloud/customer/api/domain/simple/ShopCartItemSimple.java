package com.haoxuer.b2bcloud.customer.api.domain.simple;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTradeItemSimple;
import lombok.Data;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */

@Data
public class ShopCartItemSimple implements Serializable {

    private Long id;

    private Boolean trade;

    private Integer size;

    private String name;

    private String logo;

    private Long product;

    private BigDecimal price;

    List<OrderTradeItemSimple> items;


}