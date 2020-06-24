package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月06日21:17:43.
*/

@Data
public class OrderTradeDeleteRequest extends TenantRequest {

    private Long id;

}