package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTradeItemSimple;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;
import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.util.List;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */

@Data
public class ShopCartItemResponse extends ResponseObject {

    private Long id;

    private Boolean trade;

    private Integer size;

    private Long product;

    private String name;

    private String logo;

    List<OrderTradeItemSimple> items;

}