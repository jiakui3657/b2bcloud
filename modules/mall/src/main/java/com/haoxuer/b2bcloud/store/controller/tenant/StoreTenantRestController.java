package com.haoxuer.b2bcloud.store.controller.tenant;

import com.haoxuer.b2bcloud.store.api.apis.StoreApi;
import com.haoxuer.b2bcloud.store.api.domain.list.StoreList;
import com.haoxuer.b2bcloud.store.api.domain.page.StorePage;
import com.haoxuer.b2bcloud.store.api.domain.request.*;
import com.haoxuer.b2bcloud.store.api.domain.response.StoreResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/store")
@RestController
public class StoreTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public StoreResponse create(StoreCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public StoreResponse update(StoreUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public StoreResponse delete(StoreDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public StoreList list(StoreListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public StorePage search(StoreSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public StoreResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private StoreApi api;

}
