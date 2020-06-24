package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年04月28日18:51:06.
*/

@Data
public class CustomerDeleteRequest extends TenantRequest {

    private Long id;

}