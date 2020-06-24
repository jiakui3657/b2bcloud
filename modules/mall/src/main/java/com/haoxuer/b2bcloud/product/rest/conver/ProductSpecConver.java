package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductSpecSimple;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductSpecConver implements Conver<ProductSpecSimple,ProductSpec> {
    @Override
    public ProductSpecSimple conver(ProductSpec source) {
        ProductSpecSimple result=new ProductSpecSimple();
        result.setId(source.getId());
        result.setLabel(source.getName());
        if (source.getSpecs()!=null){
            result.setItems(ConverResourceUtils.converCollect(source.getSpecs(),new ProductSpecValueSimpleConver()));
        }
        return result;
    }
}
