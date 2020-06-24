package com.haoxuer.b2bcloud.promote.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.promote.data.entity.Coupon;

/**
* Created by imake on 2020年05月06日21:50:05.
*/
public interface CouponDao extends BaseDao<Coupon,Long>{

	 Coupon findById(Long id);

	 Coupon save(Coupon bean);

	 Coupon updateByUpdater(Updater<Coupon> updater);

	 Coupon deleteById(Long id);

	 Coupon findById(Long tenant, Long id);

     Coupon deleteById(Long tenant, Long id);
}