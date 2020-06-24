package com.haoxuer.b2bcloud.purchase.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日13:54:52.
*/

@Data
public class SupplierDeleteRequest extends TenantRequest {

    private Long id;

}