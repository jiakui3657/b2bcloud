package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderExchange;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月12日18:42:45.
*/
public interface OrderExchangeService {

	OrderExchange findById(Long id);

	OrderExchange save(OrderExchange bean);

	OrderExchange update(OrderExchange bean);

	OrderExchange deleteById(Long id);
	
	OrderExchange[] deleteByIds(Long[] ids);
	
	Page<OrderExchange> page(Pageable pageable);
	
	Page<OrderExchange> page(Pageable pageable, Object search);


	List<OrderExchange> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderExchange findById(Long tenant, Long id);

    OrderExchange deleteById(Long tenant, Long id);

}