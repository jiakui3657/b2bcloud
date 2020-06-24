package com.haoxuer.b2bcloud.customer.data.service;

import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月09日15:47:39.
*/
public interface CustomerTagService {

	CustomerTag findById(Long id);

	CustomerTag save(CustomerTag bean);

	CustomerTag update(CustomerTag bean);

	CustomerTag deleteById(Long id);
	
	CustomerTag[] deleteByIds(Long[] ids);
	
	Page<CustomerTag> page(Pageable pageable);
	
	Page<CustomerTag> page(Pageable pageable, Object search);


	List<CustomerTag> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	CustomerTag findById(Long tenant, Long id);

    CustomerTag deleteById(Long tenant, Long id);

}