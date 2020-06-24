package com.haoxuer.b2bcloud.finance.data.service;

import com.haoxuer.b2bcloud.finance.data.entity.Bill;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年04月13日17:52:50.
*/
public interface BillService {

	Bill findById(Long id);

	Bill save(Bill bean);

	Bill update(Bill bean);

	Bill deleteById(Long id);
	
	Bill[] deleteByIds(Long[] ids);
	
	Page<Bill> page(Pageable pageable);
	
	Page<Bill> page(Pageable pageable, Object search);


	List<Bill> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}