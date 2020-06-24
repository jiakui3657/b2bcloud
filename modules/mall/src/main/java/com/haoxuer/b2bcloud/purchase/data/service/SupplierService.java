package com.haoxuer.b2bcloud.purchase.data.service;

import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月12日19:55:07.
*/
public interface SupplierService {

	Supplier findById(Long id);

	Supplier save(Supplier bean);

	Supplier update(Supplier bean);

	Supplier deleteById(Long id);
	
	Supplier[] deleteByIds(Long[] ids);
	
	Page<Supplier> page(Pageable pageable);
	
	Page<Supplier> page(Pageable pageable, Object search);


	List<Supplier> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Supplier findById(Long tenant, Long id);

    Supplier deleteById(Long tenant, Long id);

}