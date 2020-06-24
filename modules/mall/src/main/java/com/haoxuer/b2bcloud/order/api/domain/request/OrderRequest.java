package com.haoxuer.b2bcloud.order.api.domain.request;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest extends TenantPageRequest {


    private List<OrderItemSimple> items;

    private String note;

    private String openId;

    private String subAppId;

    private String subMchId;

    private String handle;

    //地址id
    private Long address;
}
