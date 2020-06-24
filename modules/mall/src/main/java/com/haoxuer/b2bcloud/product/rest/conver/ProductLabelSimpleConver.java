package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductLabelSimple;
import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductLabelSimpleConver implements Conver<ProductLabelSimple, ProductLabel> {
    @Override
    public ProductLabelSimple conver(ProductLabel source) {
        ProductLabelSimple result = new ProductLabelSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
