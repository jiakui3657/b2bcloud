package com.haoxuer.b2bcloud.order.conver;

import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.b2bcloud.order.vo.OrderExcel;
import com.haoxuer.bigworld.pay.utils.DateUtils;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.ArrayList;
import java.util.List;

public class OrderExcelConver implements Conver<List<OrderExcel>, OrderData> {

  @Override
  public List<OrderExcel> conver(OrderData orderInfo) {
    List<OrderExcel> result=new ArrayList<>();
    OrderExcel header=new OrderExcel();
    header.setCol1("订单编号");
    header.setCol2("下单时间");
    header.setCol3("餐厅名称");
    header.setCol4("联系电话");
    header.setCol5("收货地址");
    header.setCol6("备注");
    result.add(header);

    OrderExcel order=new OrderExcel();
    order.setCol1(orderInfo.getNo()+"");
    order.setCol2(DateUtils.formatFull(orderInfo.getAddDate()));
    order.setCol3(orderInfo.getConsignee());
    order.setCol4(orderInfo.getPhone());
    order.setCol5(orderInfo.getAddress());
    order.setCol6(orderInfo.getNote());
    result.add(order);

    OrderExcel itemHeader=new OrderExcel();
    itemHeader.setCol1("商品名称");
    itemHeader.setCol2("规格");
    itemHeader.setCol3("单价");
    itemHeader.setCol4("数量");
    result.add(itemHeader);
    if (orderInfo.getItems()!=null){
      for (OrderItem item : orderInfo.getItems()) {
        OrderExcel itemInfo=new OrderExcel();
        if (item.getProduct()!=null){
          itemInfo.setCol1(""+item.getProduct().getName());
        }
        if (item.getUnit()!=null){
          itemInfo.setCol2(""+item.getUnit());
        }else{
          itemInfo.setCol2("");
        }
        itemInfo.setCol3(""+item.getPrice());
        itemInfo.setCol4(""+item.getSize());
        result.add(itemInfo);
      }
    }
    OrderExcel total=new OrderExcel();
    total.setCol1("");
    total.setCol2("");
    total.setCol3("合计");
    total.setCol4(""+orderInfo.getTotalAmount());
    result.add(total);
    return result;
  }
}
