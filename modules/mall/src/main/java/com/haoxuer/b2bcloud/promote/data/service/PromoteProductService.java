package com.haoxuer.b2bcloud.promote.data.service;

import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月11日14:14:40.
*/
public interface PromoteProductService {

	PromoteProduct findById(Long id);

	PromoteProduct save(PromoteProduct bean);

	PromoteProduct update(PromoteProduct bean);

	PromoteProduct deleteById(Long id);
	
	PromoteProduct[] deleteByIds(Long[] ids);
	
	Page<PromoteProduct> page(Pageable pageable);
	
	Page<PromoteProduct> page(Pageable pageable, Object search);


	List<PromoteProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	PromoteProduct findById(Long tenant, Long id);

    PromoteProduct deleteById(Long tenant, Long id);

}