package com.haoxuer.b2bcloud.product.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月06日22:17:46.
*/

@Data
public class ProductLabelCreateRequest extends TenantRequest {

    private String name;

}