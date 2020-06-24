package com.haoxuer.b2bcloud.purchase.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月12日19:55:07.
*/

@Data
public class SupplierViewRequest extends TenantRequest {

    private Long id;

}