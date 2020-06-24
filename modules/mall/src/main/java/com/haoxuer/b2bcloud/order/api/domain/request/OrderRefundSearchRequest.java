package com.haoxuer.b2bcloud.order.api.domain.request;

import com.haoxuer.b2bcloud.order.data.enums.AuditState;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日23:00:47.
*/

@Data
public class OrderRefundSearchRequest extends TenantPageRequest {

    @Search(name = "auditState",operator = Filter.Operator.eq)
    private AuditState auditState;

    @Search(name = "user.id",operator = Filter.Operator.eq)
    private Long refundUser;

}