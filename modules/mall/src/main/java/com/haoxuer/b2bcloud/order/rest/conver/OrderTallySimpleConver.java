package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTallySimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderTally;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrderTallySimpleConver implements Conver<OrderTallySimple, OrderTally> {
    @Override
    public OrderTallySimple conver(OrderTally source) {
        OrderTallySimple result = new OrderTallySimple();
        result.setId(source.getId());
        result.setNo(source.getNo());
        result.setConsignee(source.getConsignee());
        result.setNote(source.getNote());
        result.setAddress(source.getAddress());
        result.setPhone(source.getPhone());
        result.setState(source.getState());
        if (source.getItems() != null) {
            result.setItems(ConverResourceUtils.converList(source.getItems(), item -> {
                OrderItemSimple simple = new OrderItemSimple();
                if (item.getOrderItem()!=null){
                    simple.setId(item.getId());
                    simple.setName(item.getOrderItem().getName());
                    simple.setLogo(item.getOrderItem().getLogo());
                }
                simple.setNum(item.getSize());
                return simple;

            }));

        }


        return result;
    }
}
