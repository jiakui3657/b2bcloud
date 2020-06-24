package com.haoxuer.b2bcloud.promote.api.apis;


import com.haoxuer.b2bcloud.promote.api.domain.list.CouponList;
import com.haoxuer.b2bcloud.promote.api.domain.page.CouponPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.CouponResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface CouponApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CouponResponse create(CouponCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CouponResponse update(CouponUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    CouponResponse delete(CouponDeleteRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     CouponResponse view(ViewRequest request);


    /**
     *
     * @param request
     * @return
     */
    CouponList list(CouponListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CouponPage search(CouponSearchRequest request);

}