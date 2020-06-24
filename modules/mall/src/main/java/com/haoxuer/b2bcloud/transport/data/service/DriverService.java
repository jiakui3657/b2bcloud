package com.haoxuer.b2bcloud.transport.data.service;

import com.haoxuer.b2bcloud.transport.data.entity.Driver;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月21日16:54:58.
*/
public interface DriverService {

	Driver findById(Long id);

	Driver save(Driver bean);

	Driver update(Driver bean);

	Driver deleteById(Long id);
	
	Driver[] deleteByIds(Long[] ids);
	
	Page<Driver> page(Pageable pageable);
	
	Page<Driver> page(Pageable pageable, Object search);


	List<Driver> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}