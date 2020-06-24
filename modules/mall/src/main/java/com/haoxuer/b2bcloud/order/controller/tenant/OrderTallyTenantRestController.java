package com.haoxuer.b2bcloud.order.controller.tenant;

import com.haoxuer.b2bcloud.order.api.apis.OrderTallyApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTallyList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTallyPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/ordertally")
@RestController
public class OrderTallyTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public OrderTallyResponse create(OrderTallyCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderTallyResponse update(OrderTallyUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderTallyResponse delete(OrderTallyViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderTallyList list(OrderTallyListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderTallyPage search(OrderTallySearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderTallyResponse view(OrderTallyViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private OrderTallyApi api;

}
