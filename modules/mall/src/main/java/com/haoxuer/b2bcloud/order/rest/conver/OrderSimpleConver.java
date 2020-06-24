package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.bigworld.pay.utils.DateUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderSimpleConver implements Conver<OrderSimple, OrderData> {
    @Override
    public OrderSimple conver(OrderData source) {
        OrderSimple result = new OrderSimple();
        result.setMoney(source.getAmount());
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setNote(source.getNote());
        result.setDate(DateUtils.format1(source.getAddDate()));

        if (source.getItems() != null && source.getItems().size() > 0) {
            String name = source.getItems().get(0).getName();
            name = name + "等" + source.getProductCount() + "件商品";
            result.setNote(name);
        } else {
            result.setNote("");
        }
        return result;
    }
}
