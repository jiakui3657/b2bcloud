package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderInvoiceResponse;
import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderInvoiceResponseConver implements Conver<OrderInvoiceResponse, OrderInvoice> {
    @Override
    public OrderInvoiceResponse conver(OrderInvoice source) {
        OrderInvoiceResponse result = new OrderInvoiceResponse();
        result.setId(source.getId());
        return result;
    }
}
