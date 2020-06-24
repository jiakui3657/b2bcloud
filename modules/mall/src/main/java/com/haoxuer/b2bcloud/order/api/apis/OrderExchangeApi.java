package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderExchangeList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderExchangePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderExchangeResponse;

public interface OrderExchangeApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderExchangeResponse create(OrderExchangeCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderExchangeResponse update(OrderExchangeUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrderExchangeResponse delete(OrderExchangeViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrderExchangeResponse view(OrderExchangeViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    OrderExchangeList list(OrderExchangeListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderExchangePage search(OrderExchangeSearchRequest request);

}