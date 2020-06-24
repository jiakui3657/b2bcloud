package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年05月07日11:15:21.
*/

@Data
public class CustomerLevelResponse extends ResponseObject {

    private Long id;

    private String name;

    private BigDecimal rebate;

    private BigDecimal money;
}