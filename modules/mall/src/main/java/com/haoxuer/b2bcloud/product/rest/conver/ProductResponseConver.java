package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.response.ProductResponse;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.ArrayList;

public class ProductResponseConver implements Conver<ProductResponse, Product> {
    @Override
    public ProductResponse conver(Product source) {
        ProductResponse result = new ProductResponse();
        result.setId(source.getId());
        result.setName(source.getName());

        result.setName(source.getName());
        result.setSalePrice(source.getSalePrice());
        result.setCostPrice(source.getCostPrice());
        result.setMarketPrice(source.getMarketPrice());
        result.setInventory(source.getInventory());
        if (source.getCatalog() != null) {
            result.setCatalog(source.getCatalog().getId());
        }
        if (source.getBrand() != null) {
            result.setBrand(source.getBrand().getId());
        }
        if (source.getLabel() != null) {
            result.setLabel(source.getLabel().getId());
        }
        if (source.getSupplier()!=null){
            result.setSupplier(source.getSupplier().getId());
        }
        result.setLogo(source.getLogo());
        result.setInventory(source.getInventory());
        result.setBarCode(source.getBarCode());
        result.setUnit(source.getUnit());
        result.setVolume(source.getVolume());
        result.setWeight(source.getWeight());
        result.setNetWeight(source.getNetWeight());
        return result;
    }
}
