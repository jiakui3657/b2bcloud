package com.haoxuer.b2bcloud.customer.data.service;

import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年01月13日13:03:05.
*/
public interface CustomerService {

	Customer findById(Long id);

	Customer save(Customer bean);

	Customer update(Customer bean);

	Customer deleteById(Long id);
	
	Customer[] deleteByIds(Long[] ids);
	
	Page<Customer> page(Pageable pageable);
	
	Page<Customer> page(Pageable pageable, Object search);


	List<Customer> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}