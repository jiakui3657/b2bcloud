package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月08日10:28:40.
*/

@Data
public class OrderDataDeleteRequest extends TenantRequest {

    private Long id;

}