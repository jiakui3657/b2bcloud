package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.haoxuer.bigworld.pay.data.enums.PayState;
import lombok.Data;

/**
*
* Created by imake on 2020年05月08日10:28:40.
*/

@Data
public class OrderDataSimple implements Serializable {

    private Long id;

    private String name;

    private String no;

    private BigDecimal money;

    private String payState;

    private String addDate;

    private List<OrderItemSimple> items;
}