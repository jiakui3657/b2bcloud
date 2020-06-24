package com.haoxuer.meicloud.wms.data.service;

import com.haoxuer.meicloud.wms.data.entity.WarehouseCatalog;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年11月20日17:46:43.
*/
public interface WarehouseCatalogService {

	WarehouseCatalog findById(Integer id);

	WarehouseCatalog save(WarehouseCatalog bean);

	WarehouseCatalog update(WarehouseCatalog bean);

	WarehouseCatalog deleteById(Integer id);
	
	WarehouseCatalog[] deleteByIds(Integer[] ids);
	
	Page<WarehouseCatalog> page(Pageable pageable);
	
	Page<WarehouseCatalog> page(Pageable pageable, Object search);

	List<WarehouseCatalog> findByTops(Integer pid);


    List<WarehouseCatalog> child(Integer id,Integer max);

	List<WarehouseCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}