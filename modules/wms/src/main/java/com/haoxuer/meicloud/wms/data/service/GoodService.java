package com.haoxuer.meicloud.wms.data.service;

import com.haoxuer.meicloud.wms.data.entity.Good;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年11月20日12:11:02.
*/
public interface GoodService {

	Good findById(Long id);

	Good save(Good bean);

	Good update(Good bean);

	Good deleteById(Long id);
	
	Good[] deleteByIds(Long[] ids);
	
	Page<Good> page(Pageable pageable);
	
	Page<Good> page(Pageable pageable, Object search);


	List<Good> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}