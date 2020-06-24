package com.haoxuer.b2bcloud.order.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年06月04日16:56:41.
*/

@Data
public class OrderTallySearchRequest extends TenantPageRequest {

    //收货人
     @Search(name = "consignee",operator = Filter.Operator.like)
     private String consignee;

    //联系电话
     @Search(name = "phone",operator = Filter.Operator.like)
     private String phone;

    //客服姓名
    @Search(name = "customer.id",operator = Filter.Operator.eq)
    private Long customer;

    private String sortField;

    private String sortMethod;
}