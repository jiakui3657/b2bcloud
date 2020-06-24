package com.haoxuer.b2bcloud.customer.api.domain.simple;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
*
* Created by imake on 2020年05月07日11:15:21.
*/

@Data
public class CustomerLevelSimple implements Serializable {

    private Long id;

    private String name;

    private BigDecimal rebate;

    private BigDecimal money;
}