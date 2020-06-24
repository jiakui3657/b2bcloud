package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.simple.ShopCartItemSimple;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCartItem;
import com.haoxuer.discover.data.rest.core.Conver;

public class ShopCartItemSimpleConver implements Conver<ShopCartItemSimple, ShopCartItem> {
    @Override
    public ShopCartItemSimple conver(ShopCartItem source) {
        ShopCartItemSimple result = new ShopCartItemSimple();
        result.setId(source.getId());
        result.setTrade(source.getTrade());
        result.setSize(source.getSize());
        result.setTrade(source.getTrade());
        if (source.getProduct() != null) {
            result.setName(source.getProduct().getName());
            result.setLogo(source.getProduct().getLogo());
            result.setProduct(source.getProduct().getId());
            result.setPrice(source.getProduct().getSalePrice());
        }
        if (result.getTrade() == null) {
            result.setTrade(false);
        }
        return result;
    }
}
