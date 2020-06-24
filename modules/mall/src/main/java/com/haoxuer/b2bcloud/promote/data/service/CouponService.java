package com.haoxuer.b2bcloud.promote.data.service;

import com.haoxuer.b2bcloud.promote.data.entity.Coupon;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月06日21:50:05.
*/
public interface CouponService {

	Coupon findById(Long id);

	Coupon save(Coupon bean);

	Coupon update(Coupon bean);

	Coupon deleteById(Long id);
	
	Coupon[] deleteByIds(Long[] ids);
	
	Page<Coupon> page(Pageable pageable);
	
	Page<Coupon> page(Pageable pageable, Object search);


	List<Coupon> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Coupon findById(Long tenant, Long id);

    Coupon deleteById(Long tenant, Long id);

}