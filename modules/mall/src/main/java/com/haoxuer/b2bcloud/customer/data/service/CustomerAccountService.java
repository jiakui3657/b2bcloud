package com.haoxuer.b2bcloud.customer.data.service;

import com.haoxuer.b2bcloud.customer.data.entity.CustomerAccount;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月27日21:05:33.
*/
public interface CustomerAccountService {

	CustomerAccount findById(Long id);

	CustomerAccount save(CustomerAccount bean);

	CustomerAccount update(CustomerAccount bean);

	CustomerAccount deleteById(Long id);
	
	CustomerAccount[] deleteByIds(Long[] ids);
	
	Page<CustomerAccount> page(Pageable pageable);
	
	Page<CustomerAccount> page(Pageable pageable, Object search);


	List<CustomerAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}