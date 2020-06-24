package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年06月04日16:56:41.
*/

@Data
public class OrderTallyViewRequest extends TenantRequest {

    private Long id;

}