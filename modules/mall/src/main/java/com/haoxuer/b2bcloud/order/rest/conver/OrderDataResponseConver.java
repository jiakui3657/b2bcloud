package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderDataResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderDataResponseConver implements Conver<OrderDataResponse, OrderData> {
    @Override
    public OrderDataResponse conver(OrderData source) {
        OrderDataResponse result = new OrderDataResponse();
        result.setId(source.getId());
        return result;
    }
}
