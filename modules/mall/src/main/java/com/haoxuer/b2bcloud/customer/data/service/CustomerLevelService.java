package com.haoxuer.b2bcloud.customer.data.service;

import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月07日11:15:21.
*/
public interface CustomerLevelService {

	CustomerLevel findById(Long id);

	CustomerLevel save(CustomerLevel bean);

	CustomerLevel update(CustomerLevel bean);

	CustomerLevel deleteById(Long id);
	
	CustomerLevel[] deleteByIds(Long[] ids);
	
	Page<CustomerLevel> page(Pageable pageable);
	
	Page<CustomerLevel> page(Pageable pageable, Object search);


	List<CustomerLevel> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	CustomerLevel findById(Long tenant, Long id);

    CustomerLevel deleteById(Long tenant, Long id);

}