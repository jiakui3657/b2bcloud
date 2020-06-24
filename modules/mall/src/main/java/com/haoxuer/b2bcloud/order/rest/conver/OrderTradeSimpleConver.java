package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTradeSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderTradeSimpleConver implements Conver<OrderTradeSimple, OrderTrade> {
    @Override
    public OrderTradeSimple conver(OrderTrade source) {
        OrderTradeSimple result = new OrderTradeSimple();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setMoney(source.getMoney());
        result.setPayMoney(source.getPayMoney());
        result.setProductCount(source.getProductCount());
        if (source.getPayState() != null) {
            result.setPayState("" + source.getPayState());
        } else {
            result.setPayState("");
        }
        if (source.getPromote() != null) {
            result.setPromote(source.getPromote().getName());
        }
        if (source.getCustomer() != null) {
            result.setCustomer(source.getCustomer().getName());
        }
        if (source.getItems() != null) {
            result.setItems(ConverResourceUtils.converCollect(source.getItems(), new OrderTradeItemSimpleConver()));
        }
        return result;
    }
}
