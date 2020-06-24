package com.haoxuer.b2bcloud.promote.api.apis;


import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromotePage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteResponse;

public interface PromoteApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    PromoteResponse create(PromoteCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    PromoteResponse update(PromoteUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    PromoteResponse delete(PromoteViewRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     PromoteResponse view(PromoteViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    PromoteList list(PromoteListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    PromotePage search(PromoteSearchRequest request);

}