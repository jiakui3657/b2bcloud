package com.haoxuer.b2bcloud.product.controller.rest;

import com.haoxuer.b2bcloud.product.api.apis.ProductApi;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductLabelPage;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductPage;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductLabelSearchRequest;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductPageRequest;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductSearchRequest;
import com.haoxuer.b2bcloud.product.data.enums.ProductState;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/product")
@RestController
public class ProductRestController extends BaseRestController {

    @RequestMapping("page")
    public ProductPage page(ProductPageRequest request) {
        return api.page(request);
    }

    @RequestMapping("search")
    public ProductPage search(ProductSearchRequest request) {
        request.setState(ProductState.onSale);
        initTenant(request);
        return api.search(request);
    }
    @Autowired
    private ProductApi api;
}