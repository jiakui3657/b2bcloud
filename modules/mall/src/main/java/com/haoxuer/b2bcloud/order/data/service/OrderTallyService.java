package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderTally;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年06月04日16:56:41.
*/
public interface OrderTallyService {

	OrderTally findById(Long id);

	OrderTally save(OrderTally bean);

	OrderTally update(OrderTally bean);

	OrderTally deleteById(Long id);
	
	OrderTally[] deleteByIds(Long[] ids);
	
	Page<OrderTally> page(Pageable pageable);
	
	Page<OrderTally> page(Pageable pageable, Object search);


	List<OrderTally> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderTally findById(Long tenant, Long id);

    OrderTally deleteById(Long tenant, Long id);

}