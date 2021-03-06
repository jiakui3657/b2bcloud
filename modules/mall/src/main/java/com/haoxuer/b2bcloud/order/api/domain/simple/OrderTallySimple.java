package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Created by imake on 2020年06月04日16:56:41.
 */

@Data
public class OrderTallySimple implements Serializable {

    private Long id;

    private String no;

    private String consignee;

    private String note;

    private String address;

    private String phone;

    private String state;

    private List<OrderItemSimple> items;

}