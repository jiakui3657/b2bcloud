package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.SpuName;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月31日15:41:42.
*/
public interface SpuNameService {

	SpuName findById(Long id);

	SpuName save(SpuName bean);

	SpuName update(SpuName bean);

	SpuName deleteById(Long id);
	
	SpuName[] deleteByIds(Long[] ids);
	
	Page<SpuName> page(Pageable pageable);
	
	Page<SpuName> page(Pageable pageable, Object search);


	List<SpuName> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}