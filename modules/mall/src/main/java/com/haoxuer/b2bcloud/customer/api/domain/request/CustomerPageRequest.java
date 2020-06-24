package com.haoxuer.b2bcloud.customer.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

@Data
public class CustomerPageRequest extends TenantPageRequest {

    @Search(name = "name")
    private String name;
}
