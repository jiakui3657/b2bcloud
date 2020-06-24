package com.haoxuer.b2bcloud.promote.controller.tenant;

import com.haoxuer.b2bcloud.promote.api.apis.PromoteApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromotePage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/promote")
@RestController
public class PromoteTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public PromoteResponse create(PromoteCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public PromoteResponse update(PromoteUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public PromoteResponse delete(PromoteViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public PromoteList list(PromoteListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public PromotePage search(PromoteSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public PromoteResponse view(PromoteViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private PromoteApi api;

}
