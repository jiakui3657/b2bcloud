package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderDataApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderPage;
import com.haoxuer.b2bcloud.order.api.domain.request.OrderRequest;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mallOrderRestController")
public class OrderRestController {



    @RequestMapping("/rest/orderData/order")
    public OrderPostResponse order(@RequestBody OrderRequest request) {
        return api.order(request);
    }

    @RequestMapping("/rest/orderData/page")
    public OrderPage page(TenantPageRequest request) {
        return api.page(request);
    }

    @RequestMapping("/rest/orderData/view")
    public OrderResponse view(ViewRequest request) {
        return api.view(request);
    }

    @Autowired
    private OrderDataApi api;
}
