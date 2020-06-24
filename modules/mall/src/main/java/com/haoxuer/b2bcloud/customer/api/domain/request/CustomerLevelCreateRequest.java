package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年05月07日11:15:21.
*/

@Data
public class CustomerLevelCreateRequest extends TenantRequest {

    private String name;

    private BigDecimal rebate;

    private BigDecimal money;
}