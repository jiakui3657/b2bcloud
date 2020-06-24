package com.haoxuer.b2bcloud.transport.data.service;

import com.haoxuer.b2bcloud.transport.data.entity.DistributionSheet;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月21日16:55:54.
*/
public interface DistributionSheetService {

	DistributionSheet findById(Long id);

	DistributionSheet save(DistributionSheet bean);

	DistributionSheet update(DistributionSheet bean);

	DistributionSheet deleteById(Long id);
	
	DistributionSheet[] deleteByIds(Long[] ids);
	
	Page<DistributionSheet> page(Pageable pageable);
	
	Page<DistributionSheet> page(Pageable pageable, Object search);


	List<DistributionSheet> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}