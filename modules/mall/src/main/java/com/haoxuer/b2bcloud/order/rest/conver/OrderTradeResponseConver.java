package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderTradeResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderTradeResponseConver implements Conver<OrderTradeResponse, OrderTrade> {
    @Override
    public OrderTradeResponse conver(OrderTrade source) {
        OrderTradeResponse result = new OrderTradeResponse();
        result.setId(source.getId());
        result.setNo(source.getNo());
        return result;
    }
}
