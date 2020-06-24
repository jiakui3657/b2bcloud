package com.haoxuer.b2bcloud.finance.controller.tenant;

import com.haoxuer.b2bcloud.finance.api.apis.InvoiceApi;
import com.haoxuer.b2bcloud.finance.api.domain.list.InvoiceList;
import com.haoxuer.b2bcloud.finance.api.domain.page.InvoicePage;
import com.haoxuer.b2bcloud.finance.api.domain.request.*;
import com.haoxuer.b2bcloud.finance.api.domain.response.InvoiceResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/tenantRest/invoice")
@RestController
public class InvoiceTenantRestController extends BaseTenantRestController {


    @RequestMapping("create")
    public InvoiceResponse create(InvoiceCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public InvoiceResponse update(InvoiceUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public InvoiceResponse delete(InvoiceViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public InvoiceList list(InvoiceListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public InvoicePage search(InvoiceSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public InvoiceResponse view(InvoiceViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private InvoiceApi api;

}
