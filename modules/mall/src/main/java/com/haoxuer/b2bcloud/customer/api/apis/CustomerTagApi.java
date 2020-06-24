package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerTagList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerTagPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerTagResponse;

public interface CustomerTagApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CustomerTagResponse create(CustomerTagCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CustomerTagResponse update(CustomerTagUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    CustomerTagResponse delete(CustomerTagViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     CustomerTagResponse view(CustomerTagViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    CustomerTagList list(CustomerTagListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CustomerTagPage search(CustomerTagSearchRequest request);

}