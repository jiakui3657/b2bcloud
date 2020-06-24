package com.haoxuer.b2bcloud.order.api.domain.response;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponse extends ResponseObject {

    private Long id;

    private String note;

    private BigDecimal money;

    private String no;

    private String date;

    private Integer total;

    private String name;

    private String phone;

    private String address;

    private List<OrderItemSimple> items;
}
