package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.promote.api.domain.simple.CouponSimple;
import com.haoxuer.b2bcloud.promote.data.entity.Coupon;
import com.haoxuer.discover.data.rest.core.Conver;

public class CouponSimpleConver implements Conver<CouponSimple, Coupon> {
    @Override
    public CouponSimple conver(Coupon source) {
        CouponSimple result = new CouponSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
