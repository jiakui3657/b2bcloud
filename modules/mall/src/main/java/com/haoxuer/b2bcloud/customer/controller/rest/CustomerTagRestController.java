package com.haoxuer.b2bcloud.customer.controller.rest;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerTagApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerTagList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerTagPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerTagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/customertag")
@RestController
public class CustomerTagRestController extends BaseRestController {


    @RequestMapping("create")
    public CustomerTagResponse create(CustomerTagCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public CustomerTagResponse update(CustomerTagUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CustomerTagResponse delete(CustomerTagViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public CustomerTagList list(CustomerTagListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public CustomerTagPage search(CustomerTagSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public CustomerTagResponse view(CustomerTagViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private CustomerTagApi api;

}
