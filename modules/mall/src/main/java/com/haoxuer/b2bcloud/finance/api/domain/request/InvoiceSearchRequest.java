package com.haoxuer.b2bcloud.finance.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年05月15日17:23:37.
*/

@Data
public class InvoiceSearchRequest extends TenantPageRequest {

    //企业名称
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    //企业税号
     @Search(name = "taxNo",operator = Filter.Operator.like)
     private String taxNo;

}