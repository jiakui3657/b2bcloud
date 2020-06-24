package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerLevelList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerLevelPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerLevelResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface CustomerLevelApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CustomerLevelResponse create(CustomerLevelCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CustomerLevelResponse update(CustomerLevelUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    CustomerLevelResponse delete(CustomerLevelDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     CustomerLevelResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    CustomerLevelList list(CustomerLevelListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CustomerLevelPage search(CustomerLevelSearchRequest request);

}