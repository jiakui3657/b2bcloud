package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductSkuSimple;
import com.haoxuer.b2bcloud.product.data.entity.ProductSku;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductSkuSimpleConver implements Conver<ProductSkuSimple, ProductSku> {
    @Override
    public ProductSkuSimple conver(ProductSku source) {
        ProductSkuSimple result=new ProductSkuSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSalePrice(source.getSalePrice());
        result.setInventory(source.getInventory());
        result.setCode(source.getCode());
        result.setLogo(source.getLogo());
        result.setMarketPrice(source.getMarketPrice());
        result.setCostPrice(source.getCostPrice());
        result.setWarning(source.getWarning());
        return result;
    }
}
