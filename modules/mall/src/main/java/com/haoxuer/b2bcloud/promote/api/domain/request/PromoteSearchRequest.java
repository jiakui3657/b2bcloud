package com.haoxuer.b2bcloud.promote.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

import java.util.Date;

/**
*
* Created by imake on 2020年05月11日14:18:16.
*/

@Data
public class PromoteSearchRequest extends TenantPageRequest {

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    @Search(name = "beginDate",operator = Filter.Operator.ge)
    private Date beginDate;

    @Search(name = "endDate",operator = Filter.Operator.le)
    private Date endDate;
}