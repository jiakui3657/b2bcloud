package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年04月30日15:32:18.
*/

@Data
public class CustomerAddressDeleteRequest extends TenantRequest {

    private Long id;

}