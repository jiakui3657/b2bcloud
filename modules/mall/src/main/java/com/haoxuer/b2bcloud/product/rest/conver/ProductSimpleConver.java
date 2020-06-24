package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.product.api.domain.simple.ProductSimple;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.ArrayList;

public class ProductSimpleConver implements Conver<ProductSimple, Product> {
    @Override
    public ProductSimple conver(Product source) {
        ProductSimple result = new ProductSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSalePrice(source.getSalePrice());
        result.setVipPrice(source.getVipPrice());
        result.setMarketPrice(source.getMarketPrice());
        result.setInventory(source.getInventory());
        result.setInventory(source.getInventory());
        result.setPrice(source.getSalePrice());
        if (source.getCatalog() != null) {
            result.setCatalog(source.getCatalog().getName());
        }
        result.setBarCode(source.getBarCode());
        if (source.getSkus() != null && source.getSkus().size() > 0) {
            result.setSkus(ConverResourceUtils.converCollect(source.getSkus(), new ProductSkuSimpleConver()));
        } else {
            result.setSkus(new ArrayList<>());
        }
        result.setLogo(source.getLogo());
        result.setNum(0);
        result.setUnit(source.getUnit());
        if (result.getUnit() == null) {
            result.setUnit("");
        }
        result.setDemo(source.getDemo());
        if (result.getDemo() == null) {
            result.setDemo("");
        }
        if (source.getState()!=null){
            result.setState(""+source.getState());
        }else{
            result.setState("");
        }

        return result;
    }
}
