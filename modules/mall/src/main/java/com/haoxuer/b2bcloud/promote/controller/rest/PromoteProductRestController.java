package com.haoxuer.b2bcloud.promote.controller.rest;

import com.haoxuer.b2bcloud.promote.api.apis.PromoteProductApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteProductList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromoteProductPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/promoteproduct")
@RestController
public class PromoteProductRestController extends BaseRestController {


    @RequestMapping("create")
    public PromoteProductResponse create(PromoteProductCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public PromoteProductResponse update(PromoteProductUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public PromoteProductResponse delete(PromoteProductViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public PromoteProductList list(PromoteProductListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public PromoteProductPage search(PromoteProductSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public PromoteProductResponse view(PromoteProductViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private PromoteProductApi api;

}
