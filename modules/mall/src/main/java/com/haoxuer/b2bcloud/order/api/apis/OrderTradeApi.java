package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderTradeList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTradePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTradeResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface OrderTradeApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderTradeResponse create(OrderTradeCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderTradeResponse update(OrderTradeUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrderTradeResponse delete(OrderTradeViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrderTradeResponse view(OrderTradeViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    OrderTradeList list(OrderTradeListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderTradePage search(OrderTradeSearchRequest request);

    /**
     * 下单
     *
     * @param request
     * @return
     */
    OrderPostResponse order(OrderRequest request);

    OrderPostResponse rePay(OrderTradeRePayRequest request);


}