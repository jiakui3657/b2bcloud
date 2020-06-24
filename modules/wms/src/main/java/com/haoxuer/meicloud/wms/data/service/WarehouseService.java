package com.haoxuer.meicloud.wms.data.service;

import com.haoxuer.meicloud.wms.data.entity.Warehouse;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年11月20日17:50:41.
*/
public interface WarehouseService {

	Warehouse findById(Long id);

	Warehouse save(Warehouse bean);

	Warehouse update(Warehouse bean);

	Warehouse deleteById(Long id);
	
	Warehouse[] deleteByIds(Long[] ids);
	
	Page<Warehouse> page(Pageable pageable);
	
	Page<Warehouse> page(Pageable pageable, Object search);


	List<Warehouse> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}