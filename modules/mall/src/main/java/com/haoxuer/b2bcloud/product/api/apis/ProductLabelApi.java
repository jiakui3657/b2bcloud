package com.haoxuer.b2bcloud.product.api.apis;


import com.haoxuer.b2bcloud.product.api.domain.list.ProductLabelList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductLabelPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductLabelResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface ProductLabelApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ProductLabelResponse create(ProductLabelCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ProductLabelResponse update(ProductLabelUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ProductLabelResponse delete(ProductLabelDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ProductLabelResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    ProductLabelList list(ProductLabelListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ProductLabelPage search(ProductLabelSearchRequest request);

}