package com.haoxuer.b2bcloud.product.controller.rest;

import com.haoxuer.b2bcloud.product.api.apis.ProductLabelApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductLabelList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductLabelPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductLabelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/productlabel")
@RestController
public class ProductLabelRestController extends BaseRestController {


    @RequestMapping("create")
    public ProductLabelResponse create(ProductLabelCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ProductLabelResponse update(ProductLabelUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ProductLabelResponse delete(ProductLabelDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public ProductLabelList list(ProductLabelListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ProductLabelPage search(ProductLabelSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public ProductLabelResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private ProductLabelApi api;

}
