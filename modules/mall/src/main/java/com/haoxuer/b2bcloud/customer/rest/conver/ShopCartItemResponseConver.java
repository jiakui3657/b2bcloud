package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartItemResponse;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCartItem;
import com.haoxuer.discover.data.rest.core.Conver;

public class ShopCartItemResponseConver implements Conver<ShopCartItemResponse, ShopCartItem> {
    @Override
    public ShopCartItemResponse conver(ShopCartItem source) {
        ShopCartItemResponse result = new ShopCartItemResponse();
        result.setId(source.getId());
        result.setTrade(source.getTrade());
        result.setSize(source.getSize());
        if (source.getProduct() != null) {
            result.setName(source.getProduct().getName());
            result.setLogo(source.getProduct().getLogo());
            result.setProduct(source.getProduct().getId());
        }
        return result;
    }
}
