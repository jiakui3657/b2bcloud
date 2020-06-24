package com.haoxuer.b2bcloud.product.api.apis;


import com.haoxuer.b2bcloud.product.api.domain.list.ProductList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.discover.rest.base.ResponseObject;

public interface ProductApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ProductResponse create(ProductCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ProductResponse update(ProductUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ProductResponse delete(ProductDeleteRequest request);


    /**
     *
     * @param request
     * @return
     */
    ProductList list(ProductListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ProductPage search(ProductSearchRequest request);

    /**
     * 产品详情
     * @param request
     * @return
     */
    ProductResponse view(ViewRequest request);


    /**
     * 产品搜索功能
     *
     * @param request
     * @return
     */
    ProductPage page(ProductPageRequest request);

    ProductResponse offLine(ViewRequest request);

    ProductResponse onLine(ViewRequest request);


}