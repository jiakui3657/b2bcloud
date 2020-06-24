package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import lombok.Data;

/**
*
* Created by imake on 2020年05月18日19:57:06.
*/

@Data
public class OrderTradeSimple implements Serializable {

    private Long id;

     private String no;

    private String promote;

    private String payState;

    private String customer;

    private BigDecimal money;

    private BigDecimal payMoney;


    private Integer productCount;

    private List<OrderTradeItemSimple> items;



}