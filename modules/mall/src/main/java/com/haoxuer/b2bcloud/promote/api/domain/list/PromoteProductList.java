package com.haoxuer.b2bcloud.promote.api.domain.list;


import com.haoxuer.b2bcloud.promote.api.domain.simple.PromoteProductSimple;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年05月11日14:14:40.
*/

@Data
public class PromoteProductList  extends ResponseList<PromoteProductSimple> {

    private BigDecimal scale;

    private Integer mini;


}