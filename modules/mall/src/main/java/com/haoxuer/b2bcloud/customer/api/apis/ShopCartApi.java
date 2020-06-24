package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.ShopCartList;
import com.haoxuer.b2bcloud.customer.api.domain.page.ShopCartPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartResponse;

public interface ShopCartApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ShopCartResponse create(ShopCartCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ShopCartResponse update(ShopCartUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ShopCartResponse delete(ShopCartViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ShopCartResponse view(ShopCartViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    ShopCartList list(ShopCartListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ShopCartPage search(ShopCartSearchRequest request);

}