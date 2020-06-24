package com.haoxuer.b2bcloud.customer.controller.tenant;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenantRest/customer")
@RestController
public class CustomerTenantRestController extends BaseTenantRestController {

    @Autowired
    TenantService tenantService;

    @RequestMapping("create")
    public CustomerResponse create(CustomerCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public CustomerResponse update(CustomerUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CustomerResponse delete(CustomerDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public CustomerList list(CustomerListRequest request) {
        initTenant(request);
        return api.list(request);
    }


    @RequestMapping("search")
    public CustomerPage search(CustomerSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @Autowired
    private CustomerApi api;

}
