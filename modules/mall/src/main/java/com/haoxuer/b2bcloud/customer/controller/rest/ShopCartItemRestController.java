package com.haoxuer.b2bcloud.customer.controller.rest;

import com.haoxuer.b2bcloud.customer.api.apis.ShopCartItemApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.ShopCartItemList;
import com.haoxuer.b2bcloud.customer.api.domain.page.ShopCartItemPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/shopcartitem")
@RestController
public class ShopCartItemRestController extends BaseRestController {


    @RequestMapping("create")
    public ShopCartItemResponse create(ShopCartItemCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ShopCartItemResponse update(ShopCartItemUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ShopCartItemResponse delete(ShopCartItemViewRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public ShopCartItemList list(ShopCartItemListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ShopCartItemPage search(ShopCartItemSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public ShopCartItemResponse view(ShopCartItemViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private ShopCartItemApi api;

}
