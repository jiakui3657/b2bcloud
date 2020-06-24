package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日23:00:47.
*/

@Data
public class OrderRefundViewRequest extends TenantRequest {

    private Long id;

}