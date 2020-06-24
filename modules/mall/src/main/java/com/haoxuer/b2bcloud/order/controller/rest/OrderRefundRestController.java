package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderRefundApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderRefundList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderRefundPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderRefundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/orderrefund")
@RestController
public class OrderRefundRestController extends BaseRestController {


    @RequestMapping("create")
    public OrderRefundResponse create(@RequestBody OrderRefundCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderRefundResponse update(OrderRefundUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderRefundResponse delete(OrderRefundViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderRefundList list(OrderRefundListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderRefundPage search(OrderRefundSearchRequest request) {
        initTenant(request);
        request.setRefundUser(request.getUser());
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderRefundResponse view(OrderRefundViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private OrderRefundApi api;

}
