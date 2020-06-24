package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductSpecValueSimple;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductSpecValueSimpleConver implements Conver<ProductSpecValueSimple, ProductSpecValue> {
    @Override
    public ProductSpecValueSimple conver(ProductSpecValue source) {
        ProductSpecValueSimple result=new ProductSpecValueSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
