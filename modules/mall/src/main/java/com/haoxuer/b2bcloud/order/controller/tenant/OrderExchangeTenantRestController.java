package com.haoxuer.b2bcloud.order.controller.tenant;

import com.haoxuer.b2bcloud.order.api.apis.OrderExchangeApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderExchangeList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderExchangePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderExchangeResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/orderexchange")
@RestController
public class OrderExchangeTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public OrderExchangeResponse create(OrderExchangeCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderExchangeResponse update(OrderExchangeUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderExchangeResponse delete(OrderExchangeViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderExchangeList list(OrderExchangeListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderExchangePage search(OrderExchangeSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderExchangeResponse view(OrderExchangeViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private OrderExchangeApi api;

}
