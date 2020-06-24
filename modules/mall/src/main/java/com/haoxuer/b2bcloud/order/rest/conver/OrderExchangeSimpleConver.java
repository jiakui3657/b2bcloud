package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderExchangeSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderExchange;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderExchangeSimpleConver implements Conver<OrderExchangeSimple, OrderExchange> {
    @Override
    public OrderExchangeSimple conver(OrderExchange source) {
        OrderExchangeSimple result = new OrderExchangeSimple();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setName(source.getName());
        result.setState(source.getState());

        return result;
    }
}
