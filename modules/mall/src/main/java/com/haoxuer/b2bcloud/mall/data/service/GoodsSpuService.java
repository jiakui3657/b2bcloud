package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月29日13:42:02.
*/
public interface GoodsSpuService {

	GoodsSpu findById(Long id);

	GoodsSpu save(GoodsSpu bean);

	GoodsSpu update(GoodsSpu bean);

	GoodsSpu deleteById(Long id);
	
	GoodsSpu[] deleteByIds(Long[] ids);
	
	Page<GoodsSpu> page(Pageable pageable);
	
	Page<GoodsSpu> page(Pageable pageable, Object search);


	List<GoodsSpu> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}