package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerResponse;

public interface CustomerApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CustomerResponse create(CustomerCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CustomerResponse update(CustomerUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    CustomerResponse delete(CustomerDeleteRequest request);


    /**
     *
     * @param request
     * @return
     */
    CustomerList list(CustomerListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CustomerPage search(CustomerSearchRequest request);

}