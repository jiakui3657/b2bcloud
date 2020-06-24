package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.response.ProductCatalogResponse;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductCatalogResponseConver implements Conver<ProductCatalogResponse, ProductCatalog> {
    @Override
    public ProductCatalogResponse conver(ProductCatalog source) {
        ProductCatalogResponse result = new ProductCatalogResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
