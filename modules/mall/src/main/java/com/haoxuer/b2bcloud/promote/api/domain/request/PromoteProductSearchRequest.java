package com.haoxuer.b2bcloud.promote.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年05月11日14:14:40.
*/

@Data
public class PromoteProductSearchRequest extends TenantPageRequest {

    @Search(name = "product.id",operator = Filter.Operator.eq)
    private Long product;

    @Search(name = "promote.id",operator = Filter.Operator.eq)
    private Long promote;

}