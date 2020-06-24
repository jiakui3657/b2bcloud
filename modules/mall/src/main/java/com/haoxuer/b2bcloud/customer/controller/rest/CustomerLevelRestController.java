package com.haoxuer.b2bcloud.customer.controller.rest;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerLevelApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerLevelList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerLevelPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerLevelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/customerlevel")
@RestController
public class CustomerLevelRestController extends BaseRestController {


    @RequestMapping("create")
    public CustomerLevelResponse create(CustomerLevelCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public CustomerLevelResponse update(CustomerLevelUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CustomerLevelResponse delete(CustomerLevelDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public CustomerLevelList list(CustomerLevelListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public CustomerLevelPage search(CustomerLevelSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public CustomerLevelResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private CustomerLevelApi api;

}
