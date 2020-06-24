package com.haoxuer.b2bcloud.purchase.api.apis;


import com.haoxuer.b2bcloud.purchase.api.domain.list.SupplierList;
import com.haoxuer.b2bcloud.purchase.api.domain.page.SupplierPage;
import com.haoxuer.b2bcloud.purchase.api.domain.request.*;
import com.haoxuer.b2bcloud.purchase.api.domain.response.SupplierResponse;

public interface SupplierApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    SupplierResponse create(SupplierCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    SupplierResponse update(SupplierUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    SupplierResponse delete(SupplierViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     SupplierResponse view(SupplierViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    SupplierList list(SupplierListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    SupplierPage search(SupplierSearchRequest request);

}