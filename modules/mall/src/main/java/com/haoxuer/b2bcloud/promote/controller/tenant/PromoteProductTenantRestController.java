package com.haoxuer.b2bcloud.promote.controller.tenant;

import com.haoxuer.b2bcloud.promote.api.apis.PromoteProductApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteProductList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromoteProductPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteProductResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/promoteproduct")
@RestController
public class PromoteProductTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public PromoteProductResponse create(PromoteProductCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public PromoteProductResponse update(PromoteProductUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public PromoteProductResponse delete(PromoteProductViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public PromoteProductList list(PromoteProductListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public PromoteProductPage search(PromoteProductSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public PromoteProductResponse view(PromoteProductViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private PromoteProductApi api;

}
