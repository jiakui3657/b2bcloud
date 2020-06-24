package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTradeItemSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderTradeItemSimpleConver implements Conver<OrderTradeItemSimple, OrderTradeItem> {
    @Override
    public OrderTradeItemSimple conver(OrderTradeItem source) {
        OrderTradeItemSimple result = new OrderTradeItemSimple();
        result.setId(source.getId());
        result.setLogo(source.getLogo());
        result.setName(source.getName());
        result.setPrice(source.getPrice());
        result.setSize(source.getSize());
        result.setUseNum(source.getUseNum());
        return result;
    }
}
