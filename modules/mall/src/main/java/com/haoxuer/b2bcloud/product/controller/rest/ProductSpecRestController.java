package com.haoxuer.b2bcloud.product.controller.rest;


import com.haoxuer.b2bcloud.product.api.apis.ProductSpecApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductSpecList;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductSpecValueAddRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSpecRestController {

    @RequestMapping("/rest/productSpec/list")
    public ProductSpecList list(TenantPageRequest request) {
        return api.list(request);
    }

    @RequestMapping("/rest/productSpec/add")
    public ResponseObject add(ProductSpecValueAddRequest request) {
        return api.add(request);
    }

    @Autowired
    private ProductSpecApi api;

}
