package com.haoxuer.b2bcloud.order.rest.conver;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.bigworld.pay.utils.DateUtils;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.List;

public class OrderResponseConver implements Conver<OrderResponse, OrderData> {
  @Override
  public OrderResponse conver(OrderData source) {
    OrderResponse result = new OrderResponse();
    result.setMoney(source.getAmount());
    result.setId(source.getId());
    result.setNo(source.getNo());
    result.setNote(source.getNote());
    result.setDate(DateUtils.format1(source.getAddDate()));
    result.setAddress(source.getAddress());
    result.setPhone(source.getPhone());
    result.setName(source.getConsignee());
    result.setTotal(source.getProductCount());
    if (source.getItems() != null) {
      List<OrderItemSimple> simples = ConverResourceUtils.converCollect(source.getItems(), new OrderItemSimpleConver());
      result.setItems(simples);
    }
    if (result.getNote()==null){
      result.setNote("");
    }
    if (result.getName()==null){
      result.setName("");
    }
    if (result.getPhone()==null){
      result.setPhone("");
    }
    if (result.getAddress()==null){
      result.setAddress("");
    }
    return result;
  }
}
