package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderDataApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderDataList;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderPage;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTempList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderDataPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderDataResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/orderdata")
@RestController
public class OrderDataRestController extends BaseRestController {


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

    @RequestMapping("order")
    public OrderPostResponse order(OrderRequest request) {
        return api.order(request);
    }

    @RequestMapping("page")
    public OrderPage page(TenantPageRequest request) {
        return api.page(request);
    }

    @RequestMapping("orderData")
    public OrderPostResponse orderData(@RequestBody OrderRequest request) {
        return api.orderData(request);
    }

    @RequestMapping("rePay")
    public OrderPostResponse rePay(OrderDataRePayRequest request) {
        return api.rePay(request);
    }

    @RequestMapping("temps")
    public OrderTempList temps(TenantPageRequest request) {
        initTenant(request);
        return api.temps(request);
    }

    @Autowired
    private OrderDataApi api;

}
