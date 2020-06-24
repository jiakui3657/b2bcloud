package com.haoxuer.b2bcloud.product.api.domain.request;

import com.haoxuer.b2bcloud.product.data.enums.ProductState;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年04月28日13:38:35.
*/

@Data
public class ProductSearchRequest extends TenantPageRequest {

    @Search(name = "brand.id",operator = Filter.Operator.eq)
    private Long brand;

    @Search(name = "catalog.id",operator = Filter.Operator.eq)
    private Integer catalog;

    @Search(name = "label.id",operator = Filter.Operator.eq)
    private Long label;

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    @Search(name = "barCode",operator = Filter.Operator.like)
    private String code;

    @Search(name = "state",operator = Filter.Operator.eq)
    private ProductState state;
}