package com.haoxuer.b2bcloud.customer.controller.rest;


import com.haoxuer.b2bcloud.customer.api.apis.AddressApi;
import com.haoxuer.b2bcloud.customer.api.domain.page.AddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.AddressRequest;
import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {

    @RequestMapping("/rest/address/page")
    public AddressPage page(TenantPageRequest request) {
        return api.page(request);
    }

    @RequestMapping("/rest/address/add")
    public ResponseObject add(AddressRequest request) {
        return api.add(request);
    }

    @RequestMapping("/rest/address/delete")
    public ResponseObject delete(ViewRequest request) {
        return api.delete(request);
    }

    @RequestMapping("/rest/address/update")
    public ResponseObject update(AddressRequest request) {
        return api.update(request);
    }

    @RequestMapping("/rest/address/updateSingle")
    public ResponseObject updateSingle(AddressRequest request) {
        return api.updateSingle(request);
    }

    @RequestMapping("/rest/address/info")
    public AddressResponse info(TenantRequest request) {
        return api.info(request);
    }

    @Autowired
    private AddressApi api;

}
