package com.haoxuer.b2bcloud.product.controller.tenant;

import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;
import com.haoxuer.b2bcloud.product.api.apis.ProductApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductResponse;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenantRest/product")
@RestController
public class ProductTenantRestController {

    @Autowired
    TenantService tenantService;

    @RequestMapping("create")
    public ProductResponse create(ProductCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ProductResponse update(ProductUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ProductResponse delete(ProductDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public ProductList list(ProductListRequest request) {
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
    public ProductPage search(ProductSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }
    @RequestMapping("view")
    public ProductResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @RequestMapping("offLine")
    public ProductResponse offLine(ViewRequest request) {
        initTenant(request);
        return api.offLine(request);
    }

    @RequestMapping("onLine")
    public ProductResponse onLine(ViewRequest request) {
        initTenant(request);
        return api.onLine(request);
    }

    @Autowired
    private ProductApi api;

}
