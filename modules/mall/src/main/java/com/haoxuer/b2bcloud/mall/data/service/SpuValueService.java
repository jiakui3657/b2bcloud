package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.SpuValue;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月29日13:42:35.
*/
public interface SpuValueService {

	SpuValue findById(Long id);

	SpuValue save(SpuValue bean);

	SpuValue update(SpuValue bean);

	SpuValue deleteById(Long id);
	
	SpuValue[] deleteByIds(Long[] ids);
	
	Page<SpuValue> page(Pageable pageable);
	
	Page<SpuValue> page(Pageable pageable, Object search);


	List<SpuValue> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	List<SpuValue> findlist(int first, Integer size, List<Filter> filters, List<Order> orders);
}