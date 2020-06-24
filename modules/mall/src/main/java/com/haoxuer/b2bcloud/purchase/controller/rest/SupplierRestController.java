package com.haoxuer.b2bcloud.purchase.controller.rest;

import com.haoxuer.b2bcloud.purchase.api.apis.SupplierApi;
import com.haoxuer.b2bcloud.purchase.api.domain.list.SupplierList;
import com.haoxuer.b2bcloud.purchase.api.domain.page.SupplierPage;
import com.haoxuer.b2bcloud.purchase.api.domain.request.*;
import com.haoxuer.b2bcloud.purchase.api.domain.response.SupplierResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/supplier")
@RestController
public class SupplierRestController extends BaseRestController {


    @RequestMapping("create")
    public SupplierResponse create(SupplierCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public SupplierResponse update(SupplierUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public SupplierResponse delete(SupplierViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public SupplierList list(SupplierListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public SupplierPage search(SupplierSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public SupplierResponse view(SupplierViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private SupplierApi api;

}
