package com.haoxuer.b2bcloud.finance.data.service;

import com.haoxuer.b2bcloud.finance.data.entity.Invoice;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月15日17:23:36.
*/
public interface InvoiceService {

	Invoice findById(Long id);

	Invoice save(Invoice bean);

	Invoice update(Invoice bean);

	Invoice deleteById(Long id);
	
	Invoice[] deleteByIds(Long[] ids);
	
	Page<Invoice> page(Pageable pageable);
	
	Page<Invoice> page(Pageable pageable, Object search);


	List<Invoice> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Invoice findById(Long tenant, Long id);

    Invoice deleteById(Long tenant, Long id);

}