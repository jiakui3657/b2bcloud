package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductCatalogSimple;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductCatalogSimpleConver implements Conver<ProductCatalogSimple, ProductCatalog> {
    @Override
    public ProductCatalogSimple conver(ProductCatalog source) {
        ProductCatalogSimple result = new ProductCatalogSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
