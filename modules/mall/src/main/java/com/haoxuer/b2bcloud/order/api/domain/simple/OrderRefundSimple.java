package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Created by imake on 2020年05月09日23:00:47.
 */

@Data
public class OrderRefundSimple implements Serializable {

    private Long id;

    private String no;

    private String phone;

    private String name;

    private List<OrderItemSimple> items;

    private String auditState;

}