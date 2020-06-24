package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.util.List;

/**
 * Created by imake on 2020年05月09日23:00:47.
 */

@Data
public class OrderRefundCreateRequest extends TenantRequest {


    private String no;

    private String phone;

    private String name;

    private List<OrderItemSimple> items;

    private Long orderId;

}