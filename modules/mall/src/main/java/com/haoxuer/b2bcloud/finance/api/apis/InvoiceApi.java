package com.haoxuer.b2bcloud.finance.api.apis;


import com.haoxuer.b2bcloud.finance.api.domain.list.InvoiceList;
import com.haoxuer.b2bcloud.finance.api.domain.page.InvoicePage;
import com.haoxuer.b2bcloud.finance.api.domain.request.*;
import com.haoxuer.b2bcloud.finance.api.domain.response.InvoiceResponse;

public interface InvoiceApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    InvoiceResponse create(InvoiceCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    InvoiceResponse update(InvoiceUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    InvoiceResponse delete(InvoiceViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     InvoiceResponse view(InvoiceViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    InvoiceList list(InvoiceListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    InvoicePage search(InvoiceSearchRequest request);

}