package com.haoxuer.b2bcloud.finance.data.service;

import com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年04月13日17:52:21.
*/
public interface FinanceAccountService {

	FinanceAccount findById(Long id);

	FinanceAccount save(FinanceAccount bean);

	FinanceAccount update(FinanceAccount bean);

	FinanceAccount deleteById(Long id);
	
	FinanceAccount[] deleteByIds(Long[] ids);
	
	Page<FinanceAccount> page(Pageable pageable);
	
	Page<FinanceAccount> page(Pageable pageable, Object search);


	List<FinanceAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}