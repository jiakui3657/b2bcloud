package com.haoxuer.b2bcloud.order.data.service;

import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月07日11:11:37.
*/
public interface OrderInvoiceService {

	OrderInvoice findById(Long id);

	OrderInvoice save(OrderInvoice bean);

	OrderInvoice update(OrderInvoice bean);

	OrderInvoice deleteById(Long id);
	
	OrderInvoice[] deleteByIds(Long[] ids);
	
	Page<OrderInvoice> page(Pageable pageable);
	
	Page<OrderInvoice> page(Pageable pageable, Object search);


	List<OrderInvoice> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	OrderInvoice findById(Long tenant, Long id);

    OrderInvoice deleteById(Long tenant, Long id);

}