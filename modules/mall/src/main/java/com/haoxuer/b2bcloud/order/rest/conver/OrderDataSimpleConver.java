package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderDataSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.bigworld.member.utils.DateUtils;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderDataSimpleConver implements Conver<OrderDataSimple, OrderData> {
    @Override
    public OrderDataSimple conver(OrderData source) {
        OrderDataSimple result = new OrderDataSimple();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setMoney(source.getAmount());
        if (source.getItems() != null) {
            result.setItems(ConverResourceUtils.converList(source.getItems(), new OrderItemSimpleConver()));
        }
        if (source.getPayState() != null) {
            result.setPayState("" + source.getPayState());
        } else {
            result.setPayState("");
        }
        if (source.getUser()!=null){
            result.setName(source.getUser().getName());
        }
        result.setAddDate(DateUtils.formatChines(source.getAddDate()));
        return result;
    }
}
