package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderRefundList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderRefundPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderRefundResponse;

public interface OrderRefundApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderRefundResponse create(OrderRefundCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderRefundResponse update(OrderRefundUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrderRefundResponse delete(OrderRefundViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrderRefundResponse view(OrderRefundViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    OrderRefundList list(OrderRefundListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderRefundPage search(OrderRefundSearchRequest request);

}