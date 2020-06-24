package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartResponse;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;
import com.haoxuer.discover.data.rest.core.Conver;

public class ShopCartResponseConver implements Conver<ShopCartResponse, ShopCart> {
    @Override
    public ShopCartResponse conver(ShopCart source) {
        ShopCartResponse result = new ShopCartResponse();
        result.setId(source.getId());
        result.setNum(source.getNum());
        return result;
    }
}
