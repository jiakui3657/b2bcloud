package com.haoxuer.b2bcloud.finance.data.service;

import com.haoxuer.b2bcloud.finance.data.entity.FinanceStream;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年04月13日17:53:59.
*/
public interface FinanceStreamService {

	FinanceStream findById(Long id);

	FinanceStream save(FinanceStream bean);

	FinanceStream update(FinanceStream bean);

	FinanceStream deleteById(Long id);
	
	FinanceStream[] deleteByIds(Long[] ids);
	
	Page<FinanceStream> page(Pageable pageable);
	
	Page<FinanceStream> page(Pageable pageable, Object search);


	List<FinanceStream> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}