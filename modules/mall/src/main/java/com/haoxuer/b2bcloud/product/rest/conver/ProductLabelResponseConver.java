package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.response.ProductLabelResponse;
import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductLabelResponseConver implements Conver<ProductLabelResponse, ProductLabel> {
    @Override
    public ProductLabelResponse conver(ProductLabel source) {
        ProductLabelResponse result = new ProductLabelResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
