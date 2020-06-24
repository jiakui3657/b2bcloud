package com.haoxuer.b2bcloud.product.api.apis;

import com.haoxuer.b2bcloud.product.api.domain.list.ProductSpecList;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductSpecValueAddRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.discover.rest.base.ResponseObject;

public interface ProductSpecApi {

    /**
     * 获取规格集合
     * @param request
     * @return
     */
    ProductSpecList list(TenantPageRequest request);

    /**
     * 添加规格值
     *
     * @param request
     * @return
     */
    ResponseObject add(ProductSpecValueAddRequest request);
}
