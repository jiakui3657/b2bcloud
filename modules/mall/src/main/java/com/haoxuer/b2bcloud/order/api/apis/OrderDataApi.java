package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderDataList;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderPage;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTempList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderDataPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderDataResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface OrderDataApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderDataResponse create(OrderDataCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderDataResponse update(OrderDataUpdateRequest request);

    /**
     * 删除
     *
     * @param request
     * @return
     */
    OrderDataResponse delete(OrderDataDeleteRequest request);


    /**
     * 详情
     *
     * @param request
     * @return
     */
    OrderResponse view(ViewRequest request);


    /**
     * @param request
     * @return
     */
    OrderDataList list(OrderDataListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderDataPage search(OrderDataSearchRequest request);

    /**
     * 下单
     *
     * @param request
     * @return
     */
    OrderPostResponse order(OrderRequest request);

    /**
     * 下单模块
     *
     * @param request
     * @return
     */
    OrderPostResponse orderData(OrderRequest request);


    OrderPostResponse rePay(OrderDataRePayRequest request);

    /**
     * 我的订单
     *
     * @param request
     * @return
     */
    OrderPage page(TenantPageRequest request);


    /**
     * 理货中的商品
     *
     * @param request
     * @return
     */
    OrderTempList temps(TenantPageRequest request);

}