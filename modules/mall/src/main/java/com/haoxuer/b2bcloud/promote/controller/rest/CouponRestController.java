package com.haoxuer.b2bcloud.promote.controller.rest;

import com.haoxuer.b2bcloud.promote.api.apis.CouponApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.CouponList;
import com.haoxuer.b2bcloud.promote.api.domain.page.CouponPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/coupon")
@RestController
public class CouponRestController extends BaseRestController {


    @RequestMapping("create")
    public CouponResponse create(CouponCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public CouponResponse update(CouponUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CouponResponse delete(CouponDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public CouponList list(CouponListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public CouponPage search(CouponSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public CouponResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private CouponApi api;

}
