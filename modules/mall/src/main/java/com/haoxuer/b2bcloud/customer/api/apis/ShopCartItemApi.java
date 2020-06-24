package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.ShopCartItemList;
import com.haoxuer.b2bcloud.customer.api.domain.page.ShopCartItemPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartItemResponse;

public interface ShopCartItemApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ShopCartItemResponse create(ShopCartItemCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ShopCartItemResponse update(ShopCartItemUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ShopCartItemResponse delete(ShopCartItemViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ShopCartItemResponse view(ShopCartItemViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    ShopCartItemList list(ShopCartItemListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ShopCartItemPage search(ShopCartItemSearchRequest request);

}