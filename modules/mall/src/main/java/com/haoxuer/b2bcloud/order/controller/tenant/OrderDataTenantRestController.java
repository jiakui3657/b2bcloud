package com.haoxuer.b2bcloud.order.controller.tenant;

import com.haoxuer.b2bcloud.order.api.apis.OrderDataApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderDataList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderDataPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderDataResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/orderdata")
@RestController
public class OrderDataTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public OrderDataResponse create(OrderDataCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderDataResponse update(OrderDataUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderDataResponse delete(OrderDataDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderDataList list(OrderDataListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderDataPage search(OrderDataSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private OrderDataApi api;

}
