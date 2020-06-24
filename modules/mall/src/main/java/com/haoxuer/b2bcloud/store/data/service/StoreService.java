package com.haoxuer.b2bcloud.store.data.service;

import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月02日15:43:56.
*/
public interface StoreService {

	Store findById(Long id);

	Store save(Store bean);

	Store update(Store bean);

	Store deleteById(Long id);
	
	Store[] deleteByIds(Long[] ids);
	
	Page<Store> page(Pageable pageable);
	
	Page<Store> page(Pageable pageable, Object search);


	List<Store> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Store findById(Long tenant, Long id);

    Store deleteById(Long tenant, Long id);

}