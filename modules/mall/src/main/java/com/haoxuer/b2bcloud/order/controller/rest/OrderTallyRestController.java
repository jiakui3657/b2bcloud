package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderTallyApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTallyList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTallyPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/ordertally")
@RestController
public class OrderTallyRestController extends BaseRestController {


    @RequestMapping("create")
    public OrderTallyResponse create(@RequestBody OrderTallyCreateRequest request) {
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
