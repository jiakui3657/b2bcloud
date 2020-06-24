package com.haoxuer.b2bcloud.transport.data.service;

import com.haoxuer.b2bcloud.transport.data.entity.DistributionVehicle;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月21日16:54:32.
*/
public interface DistributionVehicleService {

	DistributionVehicle findById(Long id);

	DistributionVehicle save(DistributionVehicle bean);

	DistributionVehicle update(DistributionVehicle bean);

	DistributionVehicle deleteById(Long id);
	
	DistributionVehicle[] deleteByIds(Long[] ids);
	
	Page<DistributionVehicle> page(Pageable pageable);
	
	Page<DistributionVehicle> page(Pageable pageable, Object search);


	List<DistributionVehicle> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}