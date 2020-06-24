package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefundItem;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderRefundItemConver implements Conver<OrderItemSimple, OrderRefundItem> {
    @Override
    public OrderItemSimple conver(OrderRefundItem source) {
        OrderItemSimple result = new OrderItemSimple();
        if (source.getOrderItem() != null) {
            result.setLogo(source.getOrderItem().getLogo());
            result.setName(source.getOrderItem().getName());
        }
        result.setId(source.getId());
        result.setNum(source.getNum());
        return result;
    }
}
