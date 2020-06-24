package com.haoxuer.b2bcloud.order.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日11:11:37.
*/

@Data
public class OrderInvoiceCreateRequest extends TenantRequest {

    private String name;

}