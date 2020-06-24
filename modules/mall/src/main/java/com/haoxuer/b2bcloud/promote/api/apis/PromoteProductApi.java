package com.haoxuer.b2bcloud.promote.api.apis;


import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteProductList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromoteProductPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteProductResponse;

public interface PromoteProductApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    PromoteProductResponse create(PromoteProductCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    PromoteProductResponse update(PromoteProductUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    PromoteProductResponse delete(PromoteProductViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     PromoteProductResponse view(PromoteProductViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    PromoteProductList list(PromoteProductListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    PromoteProductPage search(PromoteProductSearchRequest request);

}