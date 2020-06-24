package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月18日19:57:06.
*/
public interface OrderTradeService {

	OrderTrade findById(Long id);

	OrderTrade save(OrderTrade bean);

	OrderTrade update(OrderTrade bean);

	OrderTrade deleteById(Long id);
	
	OrderTrade[] deleteByIds(Long[] ids);
	
	Page<OrderTrade> page(Pageable pageable);
	
	Page<OrderTrade> page(Pageable pageable, Object search);


	List<OrderTrade> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderTrade findById(Long tenant, Long id);

    OrderTrade deleteById(Long tenant, Long id);

}