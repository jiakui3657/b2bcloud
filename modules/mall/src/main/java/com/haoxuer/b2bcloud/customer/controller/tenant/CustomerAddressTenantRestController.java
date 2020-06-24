package com.haoxuer.b2bcloud.customer.controller.tenant;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerAddressApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerAddressList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerAddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerAddressResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenantRest/customeraddress")
@RestController
public class CustomerAddressTenantRestController {

    @Autowired
    TenantService tenantService;

    @RequestMapping("create")
    public CustomerAddressResponse create(CustomerAddressCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public CustomerAddressResponse update(CustomerAddressUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CustomerAddressResponse delete(CustomerAddressDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public CustomerAddressList list(CustomerAddressListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    private void initTenant(TenantRequest request) {
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            request.setTenant(tenant.getId());
        }
    }

    private void initTenant(TenantPageRequest request) {
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            request.setTenant(tenant.getId());
        }
    }

    @RequestMapping("search")
    public CustomerAddressPage search(CustomerAddressSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @Autowired
    private CustomerAddressApi api;

}
