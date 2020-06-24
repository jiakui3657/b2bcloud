package com.haoxuer.b2bcloud.product.api.domain.request;

import com.haoxuer.b2bcloud.product.data.enums.ProductState;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

@Data
public class ProductPageRequest extends TenantPageRequest  {

    @Search(name = "brand.id",operator = Filter.Operator.eq)
    private Long brand;

    @Search(name = "label.id",operator = Filter.Operator.eq)
    private Long label;

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    @Search(name = "code",operator = Filter.Operator.like)
    private String code;

    @Search(name = "state",operator = Filter.Operator.eq)
    private ProductState state;

}
