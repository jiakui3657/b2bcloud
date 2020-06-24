package com.haoxuer.b2bcloud.promote.api.domain.request;


import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年05月11日14:14:40.
*/

@Data
public class PromoteProductUpdateRequest extends PromoteProductCreateRequest {

    private Long id;

    private BigDecimal price;

}