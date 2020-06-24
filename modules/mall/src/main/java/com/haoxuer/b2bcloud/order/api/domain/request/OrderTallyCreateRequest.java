package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.util.List;

/**
 * Created by imake on 2020年06月04日16:56:41.
 */

@Data
public class OrderTallyCreateRequest extends TenantRequest {


    private String no;

    private String consignee;

    private String note;

    private String address;

    private String phone;

    private String state;

    private Long customerAddress;

    private List<OrderItemSimple> items;


}