package com.haoxuer.b2bcloud.order.controller.rest;

import com.haoxuer.b2bcloud.order.api.apis.OrderInvoiceApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderInvoiceList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderInvoicePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderInvoiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/orderinvoice")
@RestController
public class OrderInvoiceRestController extends BaseRestController {


    @RequestMapping("create")
    public OrderInvoiceResponse create(OrderInvoiceCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrderInvoiceResponse update(OrderInvoiceUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrderInvoiceResponse delete(OrderInvoiceDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public OrderInvoiceList list(OrderInvoiceListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrderInvoicePage search(OrderInvoiceSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public OrderInvoiceResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private OrderInvoiceApi api;

}
