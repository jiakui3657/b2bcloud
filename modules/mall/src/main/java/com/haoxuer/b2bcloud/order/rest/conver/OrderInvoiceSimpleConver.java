package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderInvoiceSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderInvoiceSimpleConver implements Conver<OrderInvoiceSimple, OrderInvoice> {
    @Override
    public OrderInvoiceSimple conver(OrderInvoice source) {
        OrderInvoiceSimple result = new OrderInvoiceSimple();
        result.setId(source.getId());
        return result;
    }
}
