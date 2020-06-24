package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.simple.ShopCartSimple;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;
import com.haoxuer.discover.data.rest.core.Conver;

public class ShopCartSimpleConver implements Conver<ShopCartSimple, ShopCart> {
    @Override
    public ShopCartSimple conver(ShopCart source) {
        ShopCartSimple result = new ShopCartSimple();
        result.setId(source.getId());
        result.setNum(source.getNum());

        return result;
    }
}
