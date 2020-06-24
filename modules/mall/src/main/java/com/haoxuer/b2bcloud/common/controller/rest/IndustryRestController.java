package com.haoxuer.b2bcloud.common.controller.rest;

import com.haoxuer.b2bcloud.common.api.apis.IndustryApi;
import com.haoxuer.b2bcloud.common.api.domain.list.IndustryList;
import com.haoxuer.b2bcloud.common.api.domain.page.IndustryPage;
import com.haoxuer.b2bcloud.common.api.domain.request.*;
import com.haoxuer.b2bcloud.common.api.domain.response.IndustryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

@RequestMapping("/rest/industry")
@RestController
public class IndustryRestController extends BaseRestController {


    @RequestMapping("create")
    public IndustryResponse create(IndustryCreateRequest request) {
        initTenant(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public IndustryResponse update(IndustryUpdateRequest request) {
        initTenant(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public IndustryResponse delete(IndustryDeleteRequest request) {
        initTenant(request);
        return api.delete(request);
    }

    @RequestMapping("list")
    public IndustryList list(IndustryListRequest request) {
        initTenant(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public IndustryPage search(IndustrySearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("view")
    public IndustryResponse view(ViewRequest request) {
        initTenant(request);
        return api.view(request);
    }

    @Autowired
    private IndustryApi api;

}
