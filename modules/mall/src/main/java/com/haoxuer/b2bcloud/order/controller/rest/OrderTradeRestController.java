package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderTradeApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTradeList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTradePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTradeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/ordertrade")
@RestController
public class OrderTradeRestController extends BaseRestController {


    @RequestMapping("create")
    public OrderTradeResponse create(OrderTradeCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderTradeResponse update(OrderTradeUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderTradeResponse delete(OrderTradeViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderTradeList list(OrderTradeListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderTradePage search(OrderTradeSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("searchByUser")
    public OrderTradePage searchByUser(OrderTradeSearchRequest request) {
        OrderTradePage result=new OrderTradePage();
        initTenant(request);
        if(request.getUser()==null){
            result.setCode(501);
            result.setMsg("无效用户token");
            return result;
        }
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderTradeResponse view(OrderTradeViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @RequestMapping("order")
    public OrderPostResponse order(@RequestBody OrderRequest request) {
        initTenant(request);
        return api.order(request);
    }

    @RequestMapping("rePay")
    public OrderPostResponse rePay(OrderTradeRePayRequest request) {
        initTenant(request);
        return api.rePay(request);
    }

    @Autowired
    private OrderTradeApi api;

}
