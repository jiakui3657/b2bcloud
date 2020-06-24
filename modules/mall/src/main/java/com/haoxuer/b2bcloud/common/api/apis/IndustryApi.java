package com.haoxuer.b2bcloud.common.api.apis;


import com.haoxuer.b2bcloud.common.api.domain.list.IndustryList;
import com.haoxuer.b2bcloud.common.api.domain.page.IndustryPage;
import com.haoxuer.b2bcloud.common.api.domain.request.*;
import com.haoxuer.b2bcloud.common.api.domain.response.IndustryResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface IndustryApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    IndustryResponse create(IndustryCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    IndustryResponse update(IndustryUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    IndustryResponse delete(IndustryDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     IndustryResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    IndustryList list(IndustryListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    IndustryPage search(IndustrySearchRequest request);

}