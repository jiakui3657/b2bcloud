package com.haoxuer.b2bcloud.transport.data.service;

import com.haoxuer.b2bcloud.transport.data.entity.VehicleType;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月21日16:54:10.
*/
public interface VehicleTypeService {

	VehicleType findById(Long id);

	VehicleType save(VehicleType bean);

	VehicleType update(VehicleType bean);

	VehicleType deleteById(Long id);
	
	VehicleType[] deleteByIds(Long[] ids);
	
	Page<VehicleType> page(Pageable pageable);
	
	Page<VehicleType> page(Pageable pageable, Object search);


	List<VehicleType> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}