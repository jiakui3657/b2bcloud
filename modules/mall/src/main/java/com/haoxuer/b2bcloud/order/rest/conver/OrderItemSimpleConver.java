package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderItemSimpleConver implements Conver<OrderItemSimple, OrderItem> {
    @Override
    public OrderItemSimple conver(OrderItem source) {
        OrderItemSimple result = new OrderItemSimple();
        result.setNum(source.getSize());
        result.setName(source.getName());
        result.setPrice(source.getPrice());
        result.setReturnNum(source.getReturnNum());
        result.setSurplusNum(source.getSurplusNum());
        result.setId(source.getId());
        result.setLogo(source.getLogo());
        result.setTempNum(0);
        return result;
    }
}
