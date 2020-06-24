package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderTally;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderTallyResponseConver implements Conver<OrderTallyResponse, OrderTally> {
    @Override
    public OrderTallyResponse conver(OrderTally source) {
        OrderTallyResponse result = new OrderTallyResponse();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setConsignee(source.getConsignee());
        result.setNote(source.getNote());
        result.setAddress(source.getAddress());
        result.setPhone(source.getPhone());
        result.setState(source.getState());
        return result;
    }
}
