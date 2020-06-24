package com.haoxuer.b2bcloud.product.controller.rest;

import com.haoxuer.b2bcloud.product.api.apis.ProductCatalogApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductCatalogList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductCatalogPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductCatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/productcatalog")
@RestController
public class ProductCatalogRestController extends BaseRestController {


    @RequestMapping("create")
    public ProductCatalogResponse create(ProductCatalogCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ProductCatalogResponse update(ProductCatalogUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ProductCatalogResponse delete(ProductCatalogDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public ProductCatalogList list(ProductCatalogListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ProductCatalogPage search(ProductCatalogSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }


    @Autowired
    private ProductCatalogApi api;

}
