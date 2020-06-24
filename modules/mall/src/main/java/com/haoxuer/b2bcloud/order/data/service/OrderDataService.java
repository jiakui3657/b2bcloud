package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
* Created by imake on 2020年05月08日10:28:40.
*/
public interface OrderDataService {

	OrderData findById(Long id);

	OrderData save(OrderData bean);

	OrderData update(OrderData bean);

	OrderData deleteById(Long id);
	
	OrderData[] deleteByIds(Long[] ids);
	
	Page<OrderData> page(Pageable pageable);
	
	Page<OrderData> page(Pageable pageable, Object search);


	List<OrderData> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderData findById(Long tenant, Long id);

    OrderData deleteById(Long tenant, Long id);

	BigDecimal sum(List<Filter> filters);


}