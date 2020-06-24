package com.haoxuer.b2bcloud.customer.controller.rest;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerApi;
import com.haoxuer.b2bcloud.customer.api.domain.request.CustomerCreateRequest;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerResponse;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/rest/customer")
@RestController
public class CustomerRestController extends BaseRestController {


    @RequestMapping("create")
    public CustomerResponse create(CustomerCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }


    @Autowired
    private CustomerApi api;
}
