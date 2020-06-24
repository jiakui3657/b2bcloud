package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderTallyList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTallyPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;

public interface OrderTallyApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderTallyResponse create(OrderTallyCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderTallyResponse update(OrderTallyUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrderTallyResponse delete(OrderTallyViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrderTallyResponse view(OrderTallyViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    OrderTallyList list(OrderTallyListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderTallyPage search(OrderTallySearchRequest request);

}