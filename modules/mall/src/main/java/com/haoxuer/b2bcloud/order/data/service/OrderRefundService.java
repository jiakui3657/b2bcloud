package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月09日23:00:47.
*/
public interface OrderRefundService {

	OrderRefund findById(Long id);

	OrderRefund save(OrderRefund bean);

	OrderRefund update(OrderRefund bean);

	OrderRefund deleteById(Long id);
	
	OrderRefund[] deleteByIds(Long[] ids);
	
	Page<OrderRefund> page(Pageable pageable);
	
	Page<OrderRefund> page(Pageable pageable, Object search);


	List<OrderRefund> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderRefund findById(Long tenant, Long id);

    OrderRefund deleteById(Long tenant, Long id);

}