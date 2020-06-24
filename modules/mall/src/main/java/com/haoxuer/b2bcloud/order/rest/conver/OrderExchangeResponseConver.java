package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderExchangeResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderExchange;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderExchangeResponseConver implements Conver<OrderExchangeResponse, OrderExchange> {
    @Override
    public OrderExchangeResponse conver(OrderExchange source) {
        OrderExchangeResponse result = new OrderExchangeResponse();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setName(source.getName());
        result.setState(source.getState());
        return result;
    }
}
