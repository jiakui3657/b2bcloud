package com.haoxuer.b2bcloud.order.api.apis;


import com.haoxuer.b2bcloud.order.api.domain.list.OrderInvoiceList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderInvoicePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderInvoiceResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface OrderInvoiceApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrderInvoiceResponse create(OrderInvoiceCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrderInvoiceResponse update(OrderInvoiceUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrderInvoiceResponse delete(OrderInvoiceDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrderInvoiceResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    OrderInvoiceList list(OrderInvoiceListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrderInvoicePage search(OrderInvoiceSearchRequest request);

}