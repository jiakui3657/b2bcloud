package com.haoxuer.b2bcloud.order.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

@Data
public class OrderTradeRePayRequest extends TenantRequest {

    private Long id;

    private String openId;
}
