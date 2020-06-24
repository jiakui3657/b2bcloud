package com.haoxuer.b2bcloud.store.api.apis;


import com.haoxuer.b2bcloud.store.api.domain.list.StoreList;
import com.haoxuer.b2bcloud.store.api.domain.page.StorePage;
import com.haoxuer.b2bcloud.store.api.domain.request.*;
import com.haoxuer.b2bcloud.store.api.domain.response.StoreResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface StoreApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    StoreResponse create(StoreCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    StoreResponse update(StoreUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    StoreResponse delete(StoreDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     StoreResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    StoreList list(StoreListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    StorePage search(StoreSearchRequest request);

}