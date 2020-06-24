package com.haoxuer.b2bcloud.order.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年05月18日19:57:06.
*/

@Data
public class OrderTradeSearchRequest extends TenantPageRequest {

    //编号
     @Search(name = "no",operator = Filter.Operator.like)
     private String tradeNo;

    //订货会
     @Search(name = "promote.name",operator = Filter.Operator.like)
     private String promote;

    //客服姓名
     @Search(name = "customer.name",operator = Filter.Operator.like)
     private String customer;

    @Search(name = "payState",operator = Filter.Operator.eq)
    private PayState payState;

}