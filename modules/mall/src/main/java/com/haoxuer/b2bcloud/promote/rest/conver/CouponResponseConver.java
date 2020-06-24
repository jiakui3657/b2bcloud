package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.promote.api.domain.response.CouponResponse;
import com.haoxuer.b2bcloud.promote.data.entity.Coupon;
import com.haoxuer.discover.data.rest.core.Conver;

public class CouponResponseConver implements Conver<CouponResponse, Coupon> {
    @Override
    public CouponResponse conver(Coupon source) {
        CouponResponse result = new CouponResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
