package com.haoxuer.b2bcloud.promote.data.service;

import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月11日14:18:16.
*/
public interface PromoteService {

	Promote findById(Long id);

	Promote save(Promote bean);

	Promote update(Promote bean);

	Promote deleteById(Long id);
	
	Promote[] deleteByIds(Long[] ids);
	
	Page<Promote> page(Pageable pageable);
	
	Page<Promote> page(Pageable pageable, Object search);


	List<Promote> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Promote findById(Long tenant, Long id);

    Promote deleteById(Long tenant, Long id);

}