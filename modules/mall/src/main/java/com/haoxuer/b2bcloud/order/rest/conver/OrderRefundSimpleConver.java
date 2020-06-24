package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderRefundSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderRefundSimpleConver implements Conver<OrderRefundSimple, OrderRefund> {
    @Override
    public OrderRefundSimple conver(OrderRefund source) {
        OrderRefundSimple result = new OrderRefundSimple();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setPhone(source.getPhone());
        result.setName(source.getName());
        if (source.getAuditState() != null) {
            result.setAuditState(source.getAuditState() + "");
        } else {
            result.setAuditState("");
        }
        return result;
    }
}
