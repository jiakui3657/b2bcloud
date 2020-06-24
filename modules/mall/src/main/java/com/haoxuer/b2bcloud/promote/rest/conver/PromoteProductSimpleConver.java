package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.rest.conver.ProductSkuSimpleConver;
import com.haoxuer.b2bcloud.promote.api.domain.simple.PromoteProductSimple;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.ArrayList;

public class PromoteProductSimpleConver implements Conver<PromoteProductSimple, PromoteProduct> {
    @Override
    public PromoteProductSimple conver(PromoteProduct source) {
        PromoteProductSimple result = new PromoteProductSimple();
        result.setId(source.getId());
        Product product = source.getProduct();
        result.setPrice(source.getPrice());
        if (product != null) {
            result.setName(product.getName());
            result.setSalePrice(product.getSalePrice());
            result.setVipPrice(product.getVipPrice());
            result.setMarketPrice(product.getMarketPrice());
            result.setInventory(product.getInventory());
            result.setInventory(product.getInventory());
            if (product.getCatalog() != null) {
                result.setCatalog(product.getCatalog().getName());
            }
            result.setBarCode(product.getBarCode());
            result.setLogo(product.getLogo());
            result.setNum(0);
            result.setUnit(product.getUnit());
            if (result.getUnit() == null) {
                result.setUnit("");
            }
            result.setDemo(product.getDemo());
            if (result.getDemo() == null) {
                result.setDemo("");
            }
        }
        return result;
    }
}
