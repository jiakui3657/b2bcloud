package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderRefundResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderRefundResponseConver implements Conver<OrderRefundResponse, OrderRefund> {
    @Override
    public OrderRefundResponse conver(OrderRefund source) {
        OrderRefundResponse result = new OrderRefundResponse();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setPhone(source.getPhone());
        result.setName(source.getName());
        return result;
    }
}
